
package hu.oenik7.web.empire;

import java.util.ArrayList;
import java.util.List;

public class WarehouseRepository {
     public static final WarehouseRepository instance = new WarehouseRepository();
    
   private List<Stock> stocks = new ArrayList<Stock>();
    
    private WarehouseRepository (){
        stocks.add(new Stock(new NaturalAsset("Water", "Drink it"),(long)5));
        stocks.add(new Stock(new NaturalAsset("Wind", "Coldddd"),(long)5));
        stocks.add(new Stock(new NaturalAsset("Rain", "You get wet"),(long)5));
        stocks.add(new Stock(new NaturalAsset("Banana", "Monkey food"),(long)5));
    }
    
    public static WarehouseRepository getInstance()
    {
        return instance;
    }

    public List<Stock> getStocks() {
        return stocks;
    }
    
}
