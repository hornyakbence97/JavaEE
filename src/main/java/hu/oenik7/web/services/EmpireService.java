
package hu.oenik7.web.services;


import hu.oenik7.web.bl.User;
import hu.oenik7.web.empire.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.Singleton;
import javax.inject.Inject;


@Singleton
public class EmpireService {

    @Inject
    EmpireRepository empireRepository;

    @Inject
    PeopleRepository peopleRepository;

    @Inject
    NaturalAssetRepository nautralAssetRepository;
    
    @Inject
    BuildingRepository buildingsRepo;

    Random rand = new Random();

    public EmpireService() {
    }

    
    public Empire getEmpire(Long empID) {
        return empireRepository.getEmpireByID(empID);
    }
    
    public void removeEmpire(Long empireID) throws Exception {
        empireRepository.remove(empireID);
        
    }
    
    public void addBuilding(long empireID,String building){
        Building building = new Building();
        switch(building){
            case "Barrack":
               building.setName(building);
               building.setDescription("Trains soldiers");
               building.setBuildingTime((long)2);
               building.setProduce(CreateStockRequirements(1));
            break;
            case "Farm":
               building.setName(building);
               building.setDescription("produces food");
               building.setBuildingTime((long)2);
               building.setProduce(CreateStockRequirements(2));
                      
            break;
            case "Blacksmith":
               building.setName(building);
               building.setDescription("do you want a powerful ring?");
               building.setBuildingTime((long)2);
               building.setProduce(CreateStockRequirements(3));
                      
            break;
            case "Mine":
               building.setName(building);
               building.setDescription("too deep");
               building.setBuildingTime((long)2);
               building.setProduce(CreateStockRequirements(4));
                      
            break;
            case "Lumberyard":
               building.setName(building);
               building.setDescription("chop-chop");
               building.setBuildingTime((long)2);
               building.setProduce(CreateStockRequirements(5));
                      
               break; 
               case "Townhall":
               building.setName(building);
               building.setDescription("ocsmanyiroda");
               building.setBuildingTime((long)2);
               building.setProduce(CreateStockRequirements(6));
                      
               break;
        }
        
        Empire emp =getEmpire(empireID);
        emp.getBuildings().add(building);
        empireRepository.Update(emp);
    }
     private ArrayList<Stock> CreateStockRequirements(int b){ 
       ArrayList<Stock> req = new ArrayList<Stock>();
        switch(b){
            case 1:
                
                 for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Stone")) {
                        req.add(new Stock(s, (long) (40)));

                    } else if (s.getName().equals("Gold")){
                        req.add(new Stock(s, (long) (20)));
                    }
                    else if (s.getName().equals("Wood")){
                        req.add(new Stock(s, (long) (30)));
                    }
                    else {
                        req.add(new Stock(s, (long) (10)));
                    }
                }
                break;
            case 2:
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Stone")) {
                        req.add(new Stock(s, (long) (10)));

                    } 
                    else if (s.getName().equals("Wood")){
                        req.add(new Stock(s, (long) (30)));
                    }
                                        else {
                        req.add(new Stock(s, (long) (10)));
                    }
                }                
                break;
            case 3:
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Stone")) {
                        req.add(new Stock(s, (long) (50)));

                    } else if (s.getName().equals("Gold")){
                        req.add(new Stock(s, (long) (10)));
                    }
                    else if (s.getName().equals("Wood")){
                        req.add(new Stock(s, (long) (40)));
                    }
                                        else {
                        req.add(new Stock(s, (long) (10)));
                    }
                }                
                break;
            case 4:
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Stone")) {
                        req.add(new Stock(s, (long) (20)));

                    } else if (s.getName().equals("Gold")){
                        req.add(new Stock(s, (long) (10)));
                    }
                    else if (s.getName().equals("Wood")){
                        req.add(new Stock(s, (long) (30)));
                    }
                                        else {
                        req.add(new Stock(s, (long) (10)));
                    }
                }                   
                break;
            case 5:
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Stone")) {
                        req.add(new Stock(s, (long) (30)));

                    } 
                    else if (s.getName().equals("Wood")){
                        req.add(new Stock(s, (long) (10)));
                    }
                                        else {
                        req.add(new Stock(s, (long) (10)));
                    }
                }   
                break;
            case 6:
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Stone")) {
                        req.add(new Stock(s, (long) (50)));

                    } else if (s.getName().equals("Gold")){
                        req.add(new Stock(s, (long) (50)));
                    }
                    else if (s.getName().equals("Wood")){
                        req.add(new Stock(s, (long) (50)));
                    }
                                        else {
                        req.add(new Stock(s, (long) (10)));
                    }
                }                    
                break;
        }        
        return req;
    }

    public Empire addEmpire(String name, String description, User user) {
        Empire emp = GenerateEmpireWithEnvironment();
        emp.setName(name);
        emp.setDescription(description);
        emp.setLevel(1L);
        emp.setUser(user);
        user.addEmpire(emp);        
        empireRepository.add(emp);
        return emp;
    }

    private Empire GenerateEmpireWithEnvironment() {
        
        int num = rand.nextInt(5);
        
        Empire empire = new Empire();
        List<NaturalAsset> nats = nautralAssetRepository.getAssets();
        for (NaturalAsset s : nats) {
            int r = rand.nextInt(11);
            empire.getProduce().add(new Stock(s, (long) (10 * r)));
        }
        switch (num) {
            case 0:
                for (People p : peopleRepository.getPeople()) {
                    if (p.getName().equals("Miner")) {
                        empire.getPopulation().add(new Population(p, (long) 30));

                    } else {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    }
                }
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Stone")) {
                        empire.getWarehouse().add(new Stock(s, (long) (10)));

                    } else {
                        empire.getWarehouse().add(new Stock(s, (long) (5)));
                    }
                }

                break;
            case 1:
                for (People p : peopleRepository.getPeople()) {
                    if (p.getName().equals("Farmer")) {
                        empire.getPopulation().add(new Population(p, (long) 30));

                    } else {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    }
                }
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Food")) {
                        empire.getWarehouse().add(new Stock(s, (long) (10)));
                    } else {
                        empire.getWarehouse().add(new Stock(s, (long) (5)));
                    }
                }

                break;
            case 2:
                for (People p : peopleRepository.getPeople()) {
                    if (p.getName().equals("Farmer")) {
                        empire.getPopulation().add(new Population(p, (long) 30));
                    } else {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    }
                }
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Food")) {
                        empire.getWarehouse().add(new Stock(s, (long) (10)));
                    } else {
                        empire.getWarehouse().add(new Stock(s, (long) (5)));
                    }
                }

                break;

            case 3:
                for (People p : peopleRepository.getPeople()) {
                    if (p.getName().equals("Soldier")) {
                        empire.getPopulation().add(new Population(p, (long) 20));

                    } else if (p.getName().equals("Badass soldier")) {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    } else {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    }
                }
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Gold")) {
                        empire.getWarehouse().add(new Stock(s, (long) (10)));
                    } else {
                        empire.getWarehouse().add(new Stock(s, (long) (5)));
                    }
                }

                break;
            case 4:
                for (People p : peopleRepository.getPeople()) {
                    if (p.getName().equals("Worker")) {
                        empire.getPopulation().add(new Population(p, (long) 20));

                    } else if (p.getName().equals("Soldier")) {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    } else {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    }
                }
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Gold")) {
                        empire.getWarehouse().add(new Stock(s, (long) (10)));
                    } else {
                        empire.getWarehouse().add(new Stock(s, (long) (5)));
                    }
                }
                break;
        }
        return empire;
    }

    public boolean ConstructNewBuilding() {
        return true;
    }

    public void TimeChanged(Empire emp) {
        for (Population p : emp.getPopulation()) {
            p.setQuantity(p.getQuantity() + 1L);
        }
        for (Stock w : emp.getWarehouse()) {
            for (Stock p : emp.getProduce()) {
                if (w.getAsset().getName().equals(p.getAsset().getName())) {
                    w.setQuantity(w.getQuantity() + p.getQuantity());
                }
            }
        }
    }

}
