
package hu.oenik7.web.bl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "species")
public class Species {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    String name, description;
    List<Quality> qualities = new ArrayList<>();

    public Species() {
    }

    public Species(String name, String description, ArrayList<Quality> qualities) {
        this.name = name;
        this.description = description;
        this.qualities = qualities;
    }

    public Species(String name, String description) {
        this.name = name;
        this.description = description;
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

    public List<Quality> getQualities() {
        return qualities;
    }

    public void setQualities(List<Quality> qualities) {
        this.qualities = qualities;
    }
    
 

}
