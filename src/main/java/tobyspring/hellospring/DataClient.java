package tobyspring.hellospring;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.TransactionManager;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import tobyspring.hellospring.data.OrderRepository;
import tobyspring.hellospring.order.Order;

import java.math.BigDecimal;

public class DataClient {

    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(DataConfig.class);
        OrderRepository repo = beanFactory.getBean(OrderRepository.class);
        JpaTransactionManager transactionManager = beanFactory.getBean(JpaTransactionManager.class);

        try {
            new TransactionTemplate(transactionManager).execute(status -> {
                Order order = new Order("123", BigDecimal.TEN);
                repo.save(order);
                System.out.println(order);

                Order order1 = new Order("123", BigDecimal.ONE);
                repo.save(order1);
                System.out.println(order1);

                return null;
            });
        } catch (DataIntegrityViolationException e) {
            System.out.println("예외 정상 흐름 반환!");
        }




    }
}
