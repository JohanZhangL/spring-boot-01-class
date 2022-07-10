package spring.gientech.kafka.kafkabaristaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableJpaRepositories
@EnableBinding(Waiter.class)
public class KafkaBaristaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaBaristaServiceApplication.class, args);
    }

}
