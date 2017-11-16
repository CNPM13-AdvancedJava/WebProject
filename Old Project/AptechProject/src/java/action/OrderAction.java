/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import controller.OrderController;
import entities.Method;
import entities.Allorder;
import entities.Product;
import entities.ProductKey;
import entities.Userkey;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Linh
 */
public class OrderAction extends ActionSupport {
    private OrderController controller;
    List<Allorder> listOrder = new ArrayList<>();
    List<Product> listProduct = new ArrayList<>();
    List<Method> listMethod = new ArrayList<>();
    List<ProductKey> listKey = new ArrayList<>();
    List<Userkey> listUser = new ArrayList<>();
    
    public OrderAction() {
        controller = new OrderController();
    }
    
    public String getAllOrderInfo() throws Exception {        
        listMethod = controller.getAllMethod();
        listUser = controller.getAllUser();
        listProduct = controller.getAllProduct();
        listKey = controller.getAllProductKey();
        listOrder = controller.getAllOrder();    
        return SUCCESS;
    }

    public List<Allorder> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<Allorder> listOrder) {
        this.listOrder = listOrder;
    }

    public OrderController getController() {
        return controller;
    }

    public void setController(OrderController controller) {
        this.controller = controller;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }
    
    
}
