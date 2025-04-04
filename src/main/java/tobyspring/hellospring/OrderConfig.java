package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tobyspring.hellospring.data.JpaOrderRepository;
import tobyspring.hellospring.order.OrderRepository;
import tobyspring.hellospring.order.OrderService;

@Configuration
@Import(DataConfig.class)
@EnableTransactionManagement
public class OrderConfig {
    @Bean
    public OrderRepository orderRepository() {
        return new JpaOrderRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderService(orderRepository());
    }
}
