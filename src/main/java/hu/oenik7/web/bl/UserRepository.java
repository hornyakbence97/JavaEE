
package hu.oenik7.web.bl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserRepository {

    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public List<User> getUsers() {

        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public void add(User pUser) {
        em.getTransaction().begin();
        em.persist(pUser);
        em.getTransaction().commit();
    }
    
    public void Update(User u)
    {
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
    }
    
    public User getUser(String pName, String pPassword) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(User.class);
        Root rt = cq.from(User.class);
        cq.select(rt);
        cq.where(cb.and(cb.equal(rt.get("name"), pName), cb.equal(rt.get("password"), pPassword)));
        return (User) em.createQuery(cq).getSingleResult();
    }

    public User getUserByName(String pName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(User.class);
        Root rt = cq.from(User.class);
        cq.select(rt);
        cq.where(cb.equal(rt.get("name"), pName));
        
        Object result = em.createQuery(cq).getSingleResult();
        if( result  != null ){
            return (User) result;
        }
        
        return null;
    }
    

    
    public UserRepository() {

    }
}