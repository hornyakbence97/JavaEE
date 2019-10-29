package com.mycompany.mavenproject2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hibryd")
public class Hibryd {

    @ManyToOne
    @JoinColumn(name = "hero_id")
    private Hero hero;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
    
    @ManyToOne
    @JoinColumn(name = "species_id")
    private Species species;
    
    private Integer percent;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hibryd() {
    }

    public Hibryd(Species species, Integer percent) {
        this.species = species;
        this.percent = percent;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

}
