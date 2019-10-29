

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
    public UserRepository createUserRepository() {
        UserRepository ur = new UserRepository();

        return ur;
    }

    @ApplicationScoped
    @Produces
    public SpeciesRepository createSpeciesRepository() {
        SpeciesRepository sr = new SpeciesRepository();

        return sr;
    }

    @ApplicationScoped
    @Produces
    public HeroRepository createHeroRepository() {
        HeroRepository ur = new HeroRepository();
        return ur;
    }

     @ApplicationScoped
    @Produces
    public PeopleRepository createPeopleRepository() {
        PeopleRepository people = new PeopleRepository();

        return people;
    }
      
    @ApplicationScoped
    @Produces
    public NaturalAssetRepository createNaturalAssetRepository() {
        NaturalAssetRepository nat = new NaturalAssetRepository();
        return nat;
    }
    
    @ApplicationScoped
    @Produces
    public EmpireRepository createEmpireRepository() {
        EmpireRepository emp = new EmpireRepository();
        return emp;
    }
  
    
    @ApplicationScoped
    @Produces
    public StockRepository createStockRepository() {
        StockRepository stck = new StockRepository();
        return stck;
    }
    
    @ApplicationScoped
    @Produces
    public BuildingRepository createBuildingRepository(){
        BuildingRepository br = new BuildingRepository();
        
        return br;
    }
    
}
