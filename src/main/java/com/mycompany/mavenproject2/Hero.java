package com.mycompany.mavenproject2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;

@Entity
@Table(name = "hero")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name, description;

    private EntityManager emm = Persistence.createEntityManagerFactory("Hero").createEntityManager();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @OneToMany(mappedBy="hero")
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
        // return hibryds;
        List<Hibryd> all = emm.createQuery("SELECT s FROM Hibryd s", Hibryd.class).getResultList();
        
        List<Hibryd> tmphibryds = new ArrayList<Hibryd>();
        
        for (Hibryd hibryd : all) {
            if (hibryd.getHero().getName().equals(name))
            {
                tmphibryds.add(hibryd);
            }
        }
        
        return tmphibryds;
    }

    public void setHibryds(List<Hibryd> hibryds) {
        //this.hibryds = hibryds;
        emm.getTransaction().begin();
        for (Hibryd hibryd : hibryds) {
            hibryd.setHero(this);
            emm.persist(hibryd);
        }
        emm.getTransaction().commit();
    }

}
