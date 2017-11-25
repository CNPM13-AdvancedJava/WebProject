package model.dbentities;
// Generated Nov 25, 2017 12:14:20 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ProductKey generated by hbm2java
 */
public class ProductKey  implements java.io.Serializable {


     private String keyId;
     private ProductDetail productDetail;
     private Integer status;
     private Set orderDetails = new HashSet(0);

    public ProductKey() {
    }

	
    public ProductKey(String keyId) {
        this.keyId = keyId;
    }
    public ProductKey(String keyId, ProductDetail productDetail, Integer status, Set orderDetails) {
       this.keyId = keyId;
       this.productDetail = productDetail;
       this.status = status;
       this.orderDetails = orderDetails;
    }
   
    public String getKeyId() {
        return this.keyId;
    }
    
    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }
    public ProductDetail getProductDetail() {
        return this.productDetail;
    }
    
    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Set getOrderDetails() {
        return this.orderDetails;
    }
    
    public void setOrderDetails(Set orderDetails) {
        this.orderDetails = orderDetails;
    }




}


