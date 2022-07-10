package spring.gientech.mq.waiterservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.gientech.mq.waiterservice.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
