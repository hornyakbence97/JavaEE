
package hu.oenik7.web.bl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hybrid")
public class Hybrid {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    
    @ManyToOne
    Species species;
    
    @ManyToOne
    Hero hero;
    
    byte percent;

    public Hybrid() {
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public Hero getHero() {
        return hero;
    }
    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public byte getPercent() {
        return percent;
    }

    public void setPercent(byte percent) {
        this.percent = percent;
    }

    public Hybrid(Species species, byte percent) {
        this.species = species;
        this.percent = percent;
    }
}
