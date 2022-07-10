package spring.gientech.mq.baristaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.gientech.mq.baristaservice.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
