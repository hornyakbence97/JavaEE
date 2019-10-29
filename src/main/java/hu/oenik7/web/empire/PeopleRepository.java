
package hu.oenik7.web.empire;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class PeopleRepository {

    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public PeopleRepository() {

    }

    public List<People> getPeople() {
        return em.createQuery("SELECT s FROM People s", People.class).getResultList();
    }

    public void add(People p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

}
