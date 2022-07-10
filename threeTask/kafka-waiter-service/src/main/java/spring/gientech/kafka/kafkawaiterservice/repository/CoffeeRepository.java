package spring.gientech.kafka.kafkawaiterservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.gientech.kafka.kafkawaiterservice.model.Coffee;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    List<Coffee> findByNameInOrderById(List<String> list);
    Coffee findByName(String name);
}
