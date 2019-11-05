
package hu.oenik7.web.empire;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class NaturalAssetRepository {
    
    private EntityManager entityManager = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();
    
    public NaturalAssetRepository() {
    }
    
    public List<NaturalAsset> getAssets() {
        return entityManager.createQuery("SELECT s FROM NaturalAsset s", NaturalAsset.class).getResultList();
    }
    
    public void add(NaturalAsset naturalAsset) {
        entityManager.getTransaction().begin();
        entityManager.persist(naturalAsset);
        entityManager.getTransaction().commit();
    }
    
    public NaturalAsset getNaturalAssetByName(String name)
    {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(NaturalAsset.class);
        Root root = criteriaQuery.from(NaturalAsset.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
        
        Object result = entityManager.createQuery(criteriaQuery).getSingleResult();
        if( result  != null ){
            return (NaturalAsset) result;
        }
        
        return null;
    }
    
    public NaturalAsset getNaturalAssetByID(Long id)
    {
       NaturalAsset naturalAsset = entityManager.find(NaturalAsset.class, id);
        return naturalAsset;
    }
    
    public List<NaturalAsset> getOrderedNaturalAssets()
    {
     return entityManager.createQuery("SELECT s FROM NaturalAsset s order by s.name " , NaturalAsset.class).getResultList();
    }
    
}
