
package hu.oenik7.web.empire;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class StockRepository {

    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public StockRepository() {

    }

    public List<Stock> getStocks() {
        //class-ra hivatkozunk.
        return em.createQuery("SELECT s FROM Stock s ORDER BY name", Stock.class).getResultList();
    }

    public Stock getStock(int id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Stock.class);
        Root rt = cq.from(Stock.class);
        cq.select(rt);
        cq.where(cb.equal(rt.get("id"), id));
        return (Stock) em.createQuery(cq).getSingleResult();
    }

}
