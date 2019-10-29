package com.mycompany.mavenproject2;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HeroRepository {
    private List<Hero> heroes = new ArrayList<>();
     private EntityManager emm = Persistence.createEntityManagerFactory("Hero").createEntityManager();

    
    public void add(Hero hero)
    {
                emm.getTransaction().begin();
        emm.persist(hero);
        emm.getTransaction().commit();
       // this.heroes.add(hero);
    }
    
    public Hero getByName(String pName) throws NullPointerException{
        for(Hero hero: this.getAll())
        {
            if(hero.getName().equals(pName))
            {
                return hero;
            }
        }
        throw new NullPointerException();
    }

//    public Hero getById(int pId) throws NullPointerException{
//        for(Hero heroe: this.heroes)
//            if(heroe.getId() == pId)
//                return species;
//        throw new NullPointerException();
//    }
//    
    public List<Hero> getAll()
    {
        return emm.createQuery("SELECT s FROM Hero s", Hero.class).getResultList();
        //return this.heroes;
    }
    
}
