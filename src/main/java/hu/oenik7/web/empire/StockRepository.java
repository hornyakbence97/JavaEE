
package hu.oenik7.web.empire;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class StockRepository {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public StockRepository() {

    }

    public List<Stock> getStocks() {
        return entityManager.createQuery("SELECT s FROM Stock s ORDER BY name", Stock.class).getResultList();
    }

    public Stock getStock(int id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Stock.class);
        Root root = criteriaQuery.from(Stock.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));
        return (Stock) entityManager.createQuery(criteriaQuery).getSingleResult();
    }

}
