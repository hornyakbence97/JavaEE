
package hu.oenik7.web.bl;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HeroRepository {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public List<Hero> getHeroes() {
        return entityManager.createQuery("SELECT hybrid FROM Hero hybrid", Hero.class).getResultList();
    }

    public void add(Hero hero) {
        entityManager.getTransaction().begin();
        for (Hybrid hybrid : hero.getHybrids()) {
            entityManager.persist(hybrid);
        }
        entityManager.persist(hero);
        entityManager.getTransaction().commit();
    }

    public void remove(long heroIdx) {
        entityManager.getTransaction().begin();
        Hero hybrid = entityManager.find(Hero.class, heroIdx);
        entityManager.remove(hybrid);
        entityManager.getTransaction().commit();
    }

    public void remove(Hero hero) {
        entityManager.getTransaction().begin();
        entityManager.remove(hero);
        entityManager.getTransaction().commit();
    }

    public void update(Hero hero) {
        entityManager.getTransaction().begin();
        for (Hybrid hybrid : hero.getHybrids()) {
            entityManager.merge(hybrid);
        }
        entityManager.merge(hero);
        entityManager.getTransaction().commit();
    }

    public Hero getHero(Long id)
    {
        Hero hero = entityManager.find(Hero.class, id);
        return hero;
    }
}
