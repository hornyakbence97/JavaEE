
package hu.oenik7.web.empire;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class BuildingRepository {

    private EntityManager EntityManager = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public BuildingRepository() {
    }

    public List<Building> getBuildings() {

        return EntityManager.createQuery("SELECT s FROM Building s", Building.class).getResultList();
    }

    public Building getBuilding(int id) {
        CriteriaBuilder criteriaBuilder = EntityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Building.class);
        Root root = criteriaQuery.from(Building.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));
        return (Building) EntityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public void add(Building building) {
        EntityManager.getTransaction().begin();
        EntityManager.persist(building);
        EntityManager.getTransaction().commit();
    }

    public Building getBuildingByName(String name) {
        CriteriaBuilder criteriaBuilder = EntityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Building.class);
        Root root = criteriaQuery.from(Building.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));

        Object result = EntityManager.createQuery(criteriaQuery).getSingleResult();
        if (result != null) {
            return (Building) result;
        }

        return null;
    }

    public Building getBuildingByID(Long id) {
        Building building = EntityManager.find(Building.class, id);
        return building;
    }

    public List<Building> getOrderedBuildings() {
        return EntityManager.createQuery("SELECT s FROM Building s order by s.name ", Building.class).getResultList();
    }
}
