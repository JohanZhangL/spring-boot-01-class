package gientech.spring.webclientrestful;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CountDownLatch;

@Slf4j
@SpringBootApplication
public class WebClientRestfulApplication implements ApplicationRunner {

    @Autowired
    private WebClient webClient;

    public static void main(String[] args) {
        SpringApplication.run(WebClientRestfulApplication.class, args);
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:8080").build();
    }

    @Override
    public void run(ApplicationArguments args) throws  Exception {

        CountDownLatch cdl = new CountDownLatch(1);
        webClient.get()
                .uri("/coffee/{id}", 1)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(t -> log.error("Error: ", t))
                .doFinally(s -> cdl.countDown())
                .subscribeOn(Schedulers.single())
                .subscribe(c -> log.info("Coffee 1: {}", c));

        cdl.await();

        webClient.get()
                .uri("/coffee/")
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToFlux(String.class)
                .toStream()
                .forEach(c -> log.info("Coffee in List: {}", c));
    }
}
