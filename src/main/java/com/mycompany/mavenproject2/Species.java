package com.mycompany.mavenproject2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "species")
public class Species {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    
    private String name, description;
    
    private List<Quality> qualities = new ArrayList<Quality>();

    @OneToMany(mappedBy="species")
    private List<Hibryd> hibryds = new ArrayList<Hibryd>();
        
    public Species() {
    }

    public Species(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
        public Species(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Species other = (Species) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
}
