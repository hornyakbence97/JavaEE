
package hu.oenik7.web.empire;

import java.util.ArrayList;
import java.util.List;


public class PopulationRepository {
    public static final PopulationRepository instance = new PopulationRepository();
    
    private List<Population> population = new ArrayList<>();
    
    private PopulationRepository (){
        population.add(new Population(new People("Jozsi","jozsikaaaaa"),(long)10));
        population.add(new Population(new People("Bela","belukaaaa"),(long)10));
        population.add(new Population(new People("Sanyi","sanyikaaa"),(long)10));
        population.add(new Population(new People("Renato","kanalasrenatooo"),(long)10));
        population.add(new Population(new People("VazulNeni","nemtagiiit"),(long)10));
    }
    
    public static PopulationRepository getInstance()
    {
        return instance;
    }

    public List<Population> getPopulation() {
        return population;
    }
    
}
