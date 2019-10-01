package com.mycompany.mavenproject2;

public class Hibryd {
    private Species species;
    private Integer percent;

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
