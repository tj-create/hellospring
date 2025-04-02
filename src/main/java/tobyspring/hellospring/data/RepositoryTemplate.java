package tobyspring.hellospring.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class RepositoryTemplate {

    @PersistenceContext
    private EntityManager em;

    public void save(Object o) {
        em.persist(o);
    }
}
