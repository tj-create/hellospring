package tobyspring.hellospring.order;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order crateOrder(String no, BigDecimal bigDecimal) {
        Order order = new Order(no, bigDecimal);
        orderRepository.save(order);

        return order;
    }
}
