
package hu.oenik7.web.bl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserRepository {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public List<User> getUsers() {

        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    public void add(User pUser) {
        entityManager.getTransaction().begin();
        entityManager.persist(pUser);
        entityManager.getTransaction().commit();
    }
    
    public void Update(User user)
    {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }
    
    public User getUser(String pName, String pPassword) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("name"), pName), criteriaBuilder.equal(root.get("password"), pPassword)));
        return (User) entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public User getUserByName(String pName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("name"), pName));
        
        Object result = entityManager.createQuery(criteriaQuery).getSingleResult();
        if( result  != null ){
            return (User) result;
        }
        
        return null;
    }

    public UserRepository() {

    }
}