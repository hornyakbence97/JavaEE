
package hu.oenik7.web.empire;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class EmpireRepository {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public EmpireRepository() {

    }

    public List<Empire> getEmpires() {
        return entityManager.createQuery("SELECT e FROM Empire e", Empire.class).getResultList();
    }

    public Empire getEmpireByID(long empireID) {
        Empire empire = entityManager.find(Empire.class, empireID);
        return empire;
    }

    public void add(Empire empire) {
        entityManager.getTransaction().begin();

        for (Population p : empire.getPopulation()) {
            entityManager.persist(p);
        }
        entityManager.persist(empire);
        entityManager.getTransaction().commit();
    }

    public void remove(long empireIdx) throws Exception {
        entityManager.getTransaction().begin();
        Empire empire = entityManager.find(Empire.class, empireIdx);        
        empire.getUser().removeEmpire(empireIdx);
        entityManager.remove(empire);
        entityManager.getTransaction().commit();
    }

    public void remove(Empire empire) {
        entityManager.getTransaction().begin();
        entityManager.remove(empire);
        entityManager.getTransaction().commit();
    }

    public void Update(Empire empire)
    {
        entityManager.getTransaction().begin();
        entityManager.merge(empire);
        entityManager.getTransaction().commit();
    }
    

    
    public List<Empire> searchEmpires(Long UserID,String name, String description, Stock minimalwh, Building building )
    {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Empire.class);
        Root root = criteriaQuery.from(Empire.class);
        List<Predicate> preds = new ArrayList<>();
        preds.add(criteriaBuilder.equal(root.get("user"), UserID));
        
        if(name != null){
        preds.add(criteriaBuilder.like(root.get("name"), "%"+name+"%"));
        }
         
        if(name != null){
        preds.add(criteriaBuilder.like(root.get("description"), "%"+description+"%"));
        }
        
        if(minimalwh != null){
        Join<Empire,Stock> stock = root.join("warehouse");
        
        }
        if(building != null)
        {
        Join<Empire, Building> building = root.join("buildings");
        }
        criteriaQuery.select(root);              
                  
        criteriaQuery.select(root).where(preds.toArray(new Predicate[]{}));
        
        Object result = entityManager.createQuery(criteriaQuery).getResultList();
        if( result  != null ){
            return (List<Empire>) result;
        }
        
        return null;
    }
    
}
