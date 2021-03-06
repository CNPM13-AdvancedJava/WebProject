package model.dbentities;
// Generated Nov 25, 2017 12:14:20 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Manufacturer generated by hbm2java
 */
public class Manufacturer implements java.io.Serializable {

    private Integer manufacturerId;
    private String manufacturerName;
    private Set productDetails = new HashSet(0);

    public Manufacturer() {
    }

    public Manufacturer(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Manufacturer(String manufacturerName, Set productDetails) {
        this.manufacturerName = manufacturerName;
        this.productDetails = productDetails;
    }

    public Integer getManufacturerId() {
        return this.manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return this.manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Set getProductDetails() {
        return this.productDetails;
    }

    public void setProductDetails(Set productDetails) {
        this.productDetails = productDetails;
    }

}
