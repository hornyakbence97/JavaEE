
package hu.oenik7.web.empire;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class PeopleRepository {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public PeopleRepository() {

    }

    public List<People> getPeople() {
        return entityManager.createQuery("SELECT s FROM People s", People.class).getResultList();
    }

    public void add(People p) {
        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
    }

}
