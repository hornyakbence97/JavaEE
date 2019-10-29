
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

    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public EmpireRepository() {

    }

    public List<Empire> getEmpires() {
        return em.createQuery("SELECT e FROM Empire e", Empire.class).getResultList();
    }

    public Empire getEmpireByID(long empireID) {
        Empire emp = em.find(Empire.class, empireID);
        return emp;
    }

    public void add(Empire emp) {
        em.getTransaction().begin();

        for (Population p : emp.getPopulation()) {
            em.persist(p);
        }
        em.persist(emp);
        em.getTransaction().commit();
    }

    public void remove(long empireIdx) throws Exception {
        em.getTransaction().begin();
        Empire emp = em.find(Empire.class, empireIdx);        
        emp.getUser().removeEmpire(empireIdx);
        em.remove(emp);
        em.getTransaction().commit();
    }

    public void remove(Empire emp) {
        em.getTransaction().begin();
        em.remove(emp);
        em.getTransaction().commit();
    }

    public void Update(Empire emp)
    {
        em.getTransaction().begin();
        em.merge(emp);
        em.getTransaction().commit();
    }
    

    
    public List<Empire> searchEmpires(Long UserID,String name, String description, Stock minimalwh, Building building )
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Empire.class);
        Root rt = cq.from(Empire.class);
        List<Predicate> preds = new ArrayList<>();
        preds.add(cb.equal(rt.get("user"), UserID));
        
        if(name != null){
        preds.add(cb.like(rt.get("name"), "%"+name+"%"));
        }
         
        if(name != null){
        preds.add(cb.like(rt.get("description"), "%"+description+"%"));
        }
        
        if(minimalwh != null){
        Join<Empire,Stock> stock = rt.join("warehouse");
        
        }
        if(building != null)
        {
        Join<Empire, Building> bld = rt.join("buildings");
        }
        cq.select(rt);              
                  
        cq.select(rt).where(preds.toArray(new Predicate[]{}));
        
        Object result = em.createQuery(cq).getResultList();
        if( result  != null ){
            return (List<Empire>) result;
        }
        
        return null;
    }
    
}
