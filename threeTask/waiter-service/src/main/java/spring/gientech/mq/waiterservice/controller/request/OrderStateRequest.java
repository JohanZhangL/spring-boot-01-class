package spring.gientech.mq.waiterservice.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import spring.gientech.mq.waiterservice.model.OrderState;

@Getter
@Setter
@ToString
public class OrderStateRequest {
    private OrderState state;
}
