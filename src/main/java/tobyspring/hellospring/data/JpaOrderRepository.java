package tobyspring.hellospring.data;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import tobyspring.hellospring.order.Order;
import tobyspring.hellospring.order.OrderRepository;


@Repository
public class JpaOrderRepository implements OrderRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }
}
