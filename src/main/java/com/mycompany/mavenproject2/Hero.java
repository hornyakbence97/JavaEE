package com.mycompany.mavenproject2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hero {
    private String name, description;
    private List<Hibryd> hibryds = new ArrayList<Hibryd>();
    private List<Quality> qualities = new ArrayList<Quality>();

    public List<Quality> getQualities() {
        return qualities;
    }

    public void setQualities(List<Quality> qualities) {
        this.qualities = qualities;
    }

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

    public List<Hibryd> getHibryds() {
        return hibryds;
    }

    public void setHibryds(List<Hibryd> hibryds) {
        this.hibryds = hibryds;
    }
    
    
}
