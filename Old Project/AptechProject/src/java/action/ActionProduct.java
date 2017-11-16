/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import controller.ControllerProduct;
import entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;


public class ActionProduct extends ActionSupport implements ServletRequestAware{
    
    private Product product;
    private Product productbyId;
    private ControllerProduct controller;
    private HttpServletRequest request;
    private List<Product> lstProduct = new ArrayList<Product>();  
    private List<Product> lstBanner = new ArrayList<Product>(); 
    private List<Product> listProductref = new ArrayList<Product>();
    
    public ActionProduct() {
        controller = new ControllerProduct();
    }      
    
    public String getAllPro()
    {
        lstProduct = controller.getAllProduct();
        return SUCCESS;
    }
    
    public String getBanner()
    {
        lstBanner = controller.getBanner();
        return SUCCESS;
    }
    
     public String getTop5()
    {
        lstProduct = controller.getTop5();
        return SUCCESS;
    }
     
    public String getProbyid()
    {
        String id = request.getParameter("productId");
        int productId = 0;
        try {
            productId = Integer.parseInt(id);
        } catch (Exception e) {
        }
        productbyId = (Product) controller.getProductById(productId);
        int gameType = productbyId.getGametype().getGametypeId();
        int numberView = productbyId.getNumberview();
        int proId = productbyId.getProductId();
        listProductref = controller.getProductRef(gameType,productId);
        controller.updateProduct(numberView, proId);
        return SUCCESS;
    }
      
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ControllerProduct getController() {
        return controller;
    }

    public void setController(ControllerProduct controller) {
        this.controller = controller;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public List<Product> getLstProduct() {
        return lstProduct;
    }

    public void setLstProduct(List<Product> lstProduct) {
        this.lstProduct = lstProduct;
    }
    
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public Product getProductbyId() {
        return productbyId;
    }

    public void setProductbyId(Product productbyId) {
        this.productbyId = productbyId;
    }
    
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
      this.request = hsr;
    }

    public List<Product> getListProductref() {
        return listProductref;
    }

    public void setListProductref(List<Product> listProductref) {
        this.listProductref = listProductref;
    }

    public List<Product> getLstBanner() {
        return lstBanner;
    }

    public void setLstBanner(List<Product> lstBanner) {
        this.lstBanner = lstBanner;
    }  
    
}
