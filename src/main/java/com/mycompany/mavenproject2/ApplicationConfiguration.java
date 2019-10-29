/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Hornyák Bence
 */
@ApplicationScoped
public class ApplicationConfiguration {
    @Produces
    @ApplicationScoped
    public UserRepository createUserRepository(){
        UserRepository ur = new UserRepository();
        try
        {
            ur.add(new User("a", "a"));
             ur.add(new User("b", "b"));
              ur.add(new User("c", "c"));
            
        }
        catch(Exception e){}
        
        return ur;
    }
    
    @Produces 
    @ApplicationScoped
    public SpeciesRepository createSpeciesRe() {
        SpeciesRepository species = new SpeciesRepository();
                species.add(new Species("Torp", "pici kék ize"));
        species.add(new Species("Elf", "nagy zold ize"));
        species.add(new Species("Ember", "....."));
        
        return species;
    }
    
    @Produces 
    @ApplicationScoped
    public HeroRepository createHeroRep() {
        HeroRepository heroes = new HeroRepository();
        
        return heroes;
    }
    
   @Produces 
   @ApplicationScoped
    public UserService createUserService() {
        UserService s = new UserService();
        return s;
    }
}
