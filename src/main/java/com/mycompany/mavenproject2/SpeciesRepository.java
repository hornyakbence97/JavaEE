package com.mycompany.mavenproject2;

import java.util.ArrayList;
import java.util.List;

public class SpeciesRepository {
    private static List<Species> species = new ArrayList<>();
    
    static{
        species.add(new Species(0,"Torp", "pici kék ize"));
        species.add(new Species(1,"Elf", "nagy zold ize"));
        species.add(new Species(2,"Ember", "....."));
    }
    
    public void add(Species pSpecies){this.species.add(pSpecies);}
    
    public Species getByName(String pName) throws NullPointerException{
        for(Species user: this.species)
            if(user.getName().equals(pName))
                return user;
        throw new NullPointerException();
    }

    public Species getById(int pId) throws NullPointerException{
        for(Species species: this.species)
            if(species.getId() == pId)
                return species;
        throw new NullPointerException();
    }
    
    public List<Species> getAll(){return this.species;}
    
}
