
package hu.oenik7.web.bl;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HeroRepository {

    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public List<Hero> getHeroes() {
        return em.createQuery("SELECT h FROM Hero h", Hero.class).getResultList();
    }

    public void add(Hero he) {
        em.getTransaction().begin();
        for (Hybrid h : he.getHybrids()) {
            em.persist(h);
        }
        em.persist(he);
        em.getTransaction().commit();
    }

    public void remove(long heroIdx) {
        em.getTransaction().begin();
        Hero h = em.find(Hero.class, heroIdx);
        em.remove(h);
        em.getTransaction().commit();
    }

    public void remove(Hero hero) {
        em.getTransaction().begin();
        em.remove(hero);
        em.getTransaction().commit();
    }

    public void update(Hero he) {
        em.getTransaction().begin();
        for (Hybrid h : he.getHybrids()) {
            em.merge(h);
        }
        em.merge(he);
        em.getTransaction().commit();
    }

    public Hero getHero(Long id)
    {
        Hero he = em.find(Hero.class, id);
        return he;
    }
}
