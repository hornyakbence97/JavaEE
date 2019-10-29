
package hu.oenik7.web.empire;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class NaturalAssetRepository {
    
    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();
    
    public NaturalAssetRepository() {
    }
    
    public List<NaturalAsset> getAssets() {
        return em.createQuery("SELECT s FROM NaturalAsset s", NaturalAsset.class).getResultList();
    }
    
    public void add(NaturalAsset n) {
        em.getTransaction().begin();
        em.persist(n);
        em.getTransaction().commit();
    }
    
    public NaturalAsset getNaturalAssetByName(String name)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(NaturalAsset.class);
        Root rt = cq.from(NaturalAsset.class);
        cq.select(rt);
        cq.where(cb.equal(rt.get("name"), name));
        
        Object result = em.createQuery(cq).getSingleResult();
        if( result  != null ){
            return (NaturalAsset) result;
        }
        
        return null;
    }
    
    public NaturalAsset getNaturalAssetByID(Long id)
    {
       NaturalAsset nst = em.find(NaturalAsset.class, id);
        return nst;
    }
    
    public List<NaturalAsset> getOrderedNaturalAssets()
    {
     return em.createQuery("SELECT s FROM NaturalAsset s order by s.name " , NaturalAsset.class).getResultList();
    }
    
}
