package spring.gientech.kafka.kafkabaristaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.gientech.kafka.kafkabaristaservice.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
