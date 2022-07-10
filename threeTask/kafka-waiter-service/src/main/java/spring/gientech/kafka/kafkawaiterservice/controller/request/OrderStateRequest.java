package spring.gientech.kafka.kafkawaiterservice.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import spring.gientech.kafka.kafkawaiterservice.model.OrderState;

@Getter
@Setter
@ToString
public class OrderStateRequest {
    private OrderState state;
}
