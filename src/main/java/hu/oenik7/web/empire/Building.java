
package hu.oenik7.web.empire;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="building")
public class Building {
    String name;
    String description;
    
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    @OneToMany(cascade = CascadeType.ALL)
    List<Stock> produce;
    
    Long buildingTime;    

    public Building(){
        
    }

    public Building(String name, String description, List<Stock> produce, Long buildingTime) {
        this.name = name;
        this.description = description;
        this.produce = produce;
        this.buildingTime = buildingTime;
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

    public List<Stock> getProduce() {
        return produce;
    }

    public void setProduce(List<Stock> produce) {
        this.produce = produce;
    }

    public Long getBuildingTime() {
        return buildingTime;
    }

    public void setBuildingTime(Long buildingTime) {
        this.buildingTime = buildingTime;
    }
    
//    public void setEmpire(Long EmpId){
//        this.
//    }

    
}
