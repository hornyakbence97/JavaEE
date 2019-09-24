package com.mycompany.mavenproject2;

public class Hibryd {
    private Species species;
    private byte percent;

    public Hibryd() {
    }

    public Hibryd(Species species, byte percent) {
        this.species = species;
        this.percent = percent;
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
    
    
}
