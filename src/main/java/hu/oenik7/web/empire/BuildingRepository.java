
package hu.oenik7.web.empire;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class BuildingRepository {

    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public BuildingRepository() {
    }

    public List<Building> getBuildings() {

        return em.createQuery("SELECT s FROM Building s", Building.class).getResultList();
    }

    public Building getBuilding(int id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Building.class);
        Root rt = cq.from(Building.class);
        cq.select(rt);
        cq.where(cb.equal(rt.get("id"), id));
        return (Building) em.createQuery(cq).getSingleResult();
    }

    public void add(Building b) {
        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
    }

    public Building getBuildingByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Building.class);
        Root rt = cq.from(Building.class);
        cq.select(rt);
        cq.where(cb.equal(rt.get("name"), name));

        Object result = em.createQuery(cq).getSingleResult();
        if (result != null) {
            return (Building) result;
        }

        return null;
    }

    public Building getBuildingByID(Long id) {
        Building nst = em.find(Building.class, id);
        return nst;
    }

    public List<Building> getOrderedBuildings() {
        return em.createQuery("SELECT s FROM Building s order by s.name ", Building.class).getResultList();
    }
}
