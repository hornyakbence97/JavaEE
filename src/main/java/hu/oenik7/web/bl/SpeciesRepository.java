
package hu.oenik7.web.bl;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SpeciesRepository {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public List<Species> getSpecies() {
        return entityManager.createQuery("SELECT s FROM Species s", Species.class).getResultList();
    }

    public void add(Species spieces) {
        entityManager.getTransaction().begin();
        entityManager.persist(spieces);
        entityManager.getTransaction().commit();
    }

}
