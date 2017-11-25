package model.dbentities;
// Generated Nov 25, 2017 12:14:20 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * PaymentMethod generated by hbm2java
 */
public class PaymentMethod  implements java.io.Serializable {


     private Integer methodId;
     private String methodName;
     private Set orders = new HashSet(0);

    public PaymentMethod() {
    }

    public PaymentMethod(String methodName, Set orders) {
       this.methodName = methodName;
       this.orders = orders;
    }
   
    public Integer getMethodId() {
        return this.methodId;
    }
    
    public void setMethodId(Integer methodId) {
        this.methodId = methodId;
    }
    public String getMethodName() {
        return this.methodName;
    }
    
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    public Set getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set orders) {
        this.orders = orders;
    }




}


