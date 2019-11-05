package hu.oenik7.web.bl;

import hu.oenik7.web.empire.Empire;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String name, password;
    private Boolean admin;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Hero> heroes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Empire> empires = new ArrayList<>();

    public User(String name, String password, Boolean admin) {
        this.name = name;
        this.password = password;
        this.admin = admin;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public List<Empire> getEmpires() {
        return empires;
    }

    public void setEmpires(List<Empire> empires) {
        this.empires = empires;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public void removeHero(long heroID) throws Exception {
        int idx = -1;
        for (int j = 0; j < heroes.size(); j++) {
            if (heroes.get(j).getId() == heroID) {
                idx = j;
            }
        }
        if(idx == -1)
        {
            throw new Exception("Hero not found in user list");
        }
                
        heroes.remove(idx);
    }

    public void addEmpire(Empire empire) {
        empires.add(empire);
    }

    public void removeEmpire(long heroID) throws Exception {
        int idx = -1;
        for (int j = 0; j < empires.size(); j++) {
            if (empires.get(j).getId() == heroID) {
                idx = j;
            }
        }
        if(idx == -1)
        {
            throw new Exception("Empire not found in user's list");
        }
                
        empires.remove(idx);
    }
    
    
}
