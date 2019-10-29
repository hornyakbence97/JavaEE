
package hu.oenik7.web.bl;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SpeciesRepository {

    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();
    //private List<Species> species = new ArrayList<>();   

    public List<Species> getSpecies() {
        //class-ra hivatkozunk.
        return em.createQuery("SELECT s FROM Species s", Species.class).getResultList();
    }

    public void add(Species s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }

}
