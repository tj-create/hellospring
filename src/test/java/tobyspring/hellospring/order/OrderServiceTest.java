package tobyspring.hellospring.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tobyspring.hellospring.OrderConfig;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = OrderConfig.class)
class OrderServiceTest {
    @Autowired
    OrderService orderService;

    @DisplayName("createOrder에 Order 정보를 주면 해당 오더가 잘 저장된다.")
    @Test
    void createOrder(){
        //given
        Order order = new Order("100", BigDecimal.TEN);

        //when
        Order savedOrder = orderService.crateOrder(order.getNo(), order.getTotal());

        //then
        Assertions.assertThat(savedOrder.getId()).isNotNull();
        Assertions.assertThat(savedOrder.getNo()).isEqualTo(order.getNo());
        Assertions.assertThat(savedOrder.getTotal()).isEqualTo(order.getTotal());

     }

}