/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hornyák Bence
 */
class Empire {
    private String name, description;
    private long level;
    private List<Population> population = new ArrayList<Population>();
    private List<Stock> produce = new ArrayList<Stock>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public List<Population> getPopulation() {
        return population;
    }

    public void setPopulation(List<Population> population) {
        this.population = population;
    }

    public List<Stock> getProduce() {
        return produce;
    }

    public void setProduce(List<Stock> produce) {
        this.produce = produce;
    }

    public List<Stock> getWarehause() {
        return warehause;
    }

    public void setWarehause(List<Stock> warehause) {
        this.warehause = warehause;
    }
    private List<Stock> warehause = new ArrayList<Stock>();
}
