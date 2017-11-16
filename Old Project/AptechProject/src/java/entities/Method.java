package entities;
// Generated Jun 7, 2016 9:33:33 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Method generated by hbm2java
 */
public class Method{


     private int methodId;
     private String methodName;
     private Set allorders = new HashSet(0);

    public Method() {
    }

	
    public Method(int methodId, String methodName) {
        this.methodId = methodId;
        this.methodName = methodName;
    }
    public Method(int methodId, String methodName, Set allorders) {
       this.methodId = methodId;
       this.methodName = methodName;
       this.allorders = allorders;
    }
   
    public int getMethodId() {
        return this.methodId;
    }
    
    public void setMethodId(int methodId) {
        this.methodId = methodId;
    }
    public String getMethodName() {
        return this.methodName;
    }
    
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    public Set getAllorders() {
        return this.allorders;
    }
    
    public void setAllorders(Set allorders) {
        this.allorders = allorders;
    }




}

