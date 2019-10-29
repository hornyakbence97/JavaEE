
package hu.oenik7.web.empire;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "stock")
public class Stock {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @ManyToOne
    NaturalAsset asset;

    Long quantity;

    public Stock() {

    }

    public Stock(NaturalAsset asset, Long quantity) {
        this.asset = asset;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NaturalAsset getAsset() {
        return asset;
    }

    public void setAsset(NaturalAsset asset) {
        this.asset = asset;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
