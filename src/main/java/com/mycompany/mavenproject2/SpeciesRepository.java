package com.mycompany.mavenproject2;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import sun.security.krb5.internal.Krb5;

public class SpeciesRepository {
    private EntityManager emm = Persistence.createEntityManagerFactory("Hero").createEntityManager();
    private List<Species> species = new ArrayList<>();
    

    
    public void add(Species pSpecies)
    {
        boolean can = true;
        
try
{
            List<Species> all = this.getAll();
        
        for (Species species1 : all) {
            if (species1.getName().equals(pSpecies.getName()) && species1.getDescription().equals(pSpecies.getDescription()))
            {
                can = false;
                break;
            }
        }
}
catch(Exception e){
}
        
        if (can)
        {
        emm.getTransaction().begin();
        emm.persist(pSpecies);
        emm.getTransaction().commit();
        }
        //this.species.add(pSpecies);
    }
    
    public Species getByName(String pName) throws NullPointerException{
        for(Species user: this.getAll())
            if(user.getName().equals(pName))
                return user;
        throw new NullPointerException();
    }

    public Species getById(int pId) throws NullPointerException{
        for(Species species: this.getAll())
            if(species.getId() == pId)
                return species;
        throw new NullPointerException();
    }
    
    public List<Species> getAll()
    {
        //return this.species;
        //return new ArrayList<Species>();
        return emm.createQuery("SELECT s FROM Species s", Species.class).getResultList();
    }
    
}
