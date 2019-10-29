
package hu.oenik7.web.bl;

import java.util.ArrayList;
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
@Table(name = "hero")
public class Hero {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    String name, description;
    
    @OneToMany(cascade = CascadeType.ALL)
    List<Hybrid> hybrids = new ArrayList<>();
    List<Quality> qualities = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name="USER_ID")        
    User user;

    public Hero(String name, String description, ArrayList<Hybrid> hybrids, ArrayList<Quality> qualities, User h) {
        this.name = name;
        this.description = description;
        this.hybrids = hybrids;
        this.qualities = qualities;
        this.user = h;
    }

    public Hero(String name, String description, ArrayList<Hybrid> hybrids, User h) {
        this.name = name;
        this.description = description;
        this.hybrids = hybrids;
        this.user = h;
    }

    public Hero(String name, String description, User h) {
        this.name = name;
        this.description = description;
        this.user = h;
    }

    public Hero() {
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

    public List<Hybrid> getHybrids() {
        return hybrids;
    }

    public void setHybrids(List<Hybrid> hybrids) {
        this.hybrids = hybrids;
    }

    public List<Quality> getQualities() {
        return qualities;
    }

    public void setQualities(List<Quality> qualities) {
        this.qualities = qualities;
    }

}
