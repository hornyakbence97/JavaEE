

import hu.oenik7.web.bl.HeroRepository;
import hu.oenik7.web.bl.SpeciesRepository;
import hu.oenik7.web.bl.UserRepository;
import hu.oenik7.web.empire.BuildingRepository;
import hu.oenik7.web.empire.EmpireRepository;
import hu.oenik7.web.empire.NaturalAssetRepository;
import hu.oenik7.web.empire.PeopleRepository;
import hu.oenik7.web.empire.StockRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;


@ApplicationScoped 
public class ApplicationConfiguration {

    @ApplicationScoped
    @Produces
    public UserRepository getUserRepository() {
        UserRepository userRepository = new UserRepository();

        return userRepository;
    }

    @ApplicationScoped
    @Produces
    public SpeciesRepository createSpeciesRepository() {
        SpeciesRepository speciesRepository = new SpeciesRepository();

        return speciesRepository;
    }

    @ApplicationScoped
    @Produces
    public HeroRepository createHeroRepository() {
        HeroRepository userRepository = new HeroRepository();
        return userRepository;
    }

     @ApplicationScoped
    @Produces
    public PeopleRepository createPeopleRepository() {
        PeopleRepository peopleRepository = new PeopleRepository();

        return peopleRepository;
    }
      
    @ApplicationScoped
    @Produces
    public NaturalAssetRepository createNaturalAssetRepository() {
        NaturalAssetRepository naturalAssetRepository = new NaturalAssetRepository();
        return naturalAssetRepository;
    }
    
    @ApplicationScoped
    @Produces
    public EmpireRepository createEmpireRepository() {
        EmpireRepository empireRepository = new EmpireRepository();
        return empireRepository;
    }
  
    
    @ApplicationScoped
    @Produces
    public StockRepository createStockRepository() {
        StockRepository stockRepository = new StockRepository();
        return stockRepository;
    }
    
    @ApplicationScoped
    @Produces
    public BuildingRepository createBuildingRepository(){
        BuildingRepository buildingRepository = new BuildingRepository();
        
        return buildingRepository;
    }
    
}
