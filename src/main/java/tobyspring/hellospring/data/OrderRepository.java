package tobyspring.hellospring.data;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import tobyspring.hellospring.order.Order;


@Repository
public class OrderRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Order order) {
        entityManager.persist(order);
    }
}
