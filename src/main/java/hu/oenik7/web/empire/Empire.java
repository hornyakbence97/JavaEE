
package hu.oenik7.web.empire;

import hu.oenik7.web.bl.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="empire")
public class Empire {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    
    String name;
    String description;
    Long level;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Empire_ID")
    List<Population> population = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="empire_produce")
    List<Stock> produce= new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="empire_warehouse")
    List<Stock> warehouse= new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Empire_ID")
    List<Building> buildings= new ArrayList<>();
    
    
    @ManyToOne
    @JoinColumn(name="USER_ID")
    User user;
    
    public Empire() {
    }

    public Empire(String name, String description, Long level, User user) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.user = user;
    }

    public Empire(String name, String description, Long level, List<Population> population, List<Stock> produce, List<Stock> warehouse, List<Building> buildings) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.population = population;
        this.produce = produce;
        this.warehouse = warehouse;
        this.buildings = buildings;
    }  


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
        public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
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

    public List<Stock> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(List<Stock> warehouse) {
        this.warehouse = warehouse;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }    

        
}