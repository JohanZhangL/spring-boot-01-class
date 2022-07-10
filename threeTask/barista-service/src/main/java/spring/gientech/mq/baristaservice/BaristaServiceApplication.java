package spring.gientech.mq.baristaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.stream.annotation.EnableBinding;
import spring.gientech.mq.baristaservice.integration.Waiter;

@SpringBootApplication
@EnableJpaRepositories
@EnableBinding(Waiter.class)
public class BaristaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaristaServiceApplication.class, args);
    }

}
