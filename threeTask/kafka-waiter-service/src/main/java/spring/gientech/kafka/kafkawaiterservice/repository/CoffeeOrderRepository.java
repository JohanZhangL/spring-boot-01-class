package spring.gientech.kafka.kafkawaiterservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.gientech.kafka.kafkawaiterservice.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
