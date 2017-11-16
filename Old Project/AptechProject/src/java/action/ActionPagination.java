/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import controller.ControllerPagination;
import entities.Pagination;
import entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 * 
 *
 * @author Nguyen
 */
public class ActionPagination extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;
    private List<Product> lstProduct;
    private Product product;
    private ControllerPagination controller;
    private Pagination pag = new Pagination();
    private List<Pagination> listPag = new ArrayList<Pagination>();  
    int n = 18;

    public ActionPagination() {
        controller = new ControllerPagination();
    }
    
    public String lstProShop() { 
        int i = 1;
        listPag = pag.getListPagging(controller.getProduct().size(), n);
        lstProduct = controller.getListProduct(n * (i - 1), n);
        return SUCCESS;
    }   
    
    public String getListProduct()
    {
        String page = request.getParameter("page");
        int i = 0;
        try {
            i = Integer.parseInt(page);

        } catch (Exception ex) {
        }
        listPag = pag.getListPagging(controller.getProduct().size(), n);
        lstProduct = controller.getListProduct(n * (i - 1), n);
        return SUCCESS;
    }
    public HttpServletRequest getRequest() {
        return request;
    }
        
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public List<Product> getLstProduct() {
        return lstProduct;
    }

    public void setLstProduct(List<Product> lstProduct) {
        this.lstProduct = lstProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ControllerPagination getController() {
        return controller;
    }

    public void setController(ControllerPagination controller) {
        this.controller = controller;
    }

    public Pagination getPag() {
        return pag;
    }

    public void setPag(Pagination pag) {
        this.pag = pag;
    }

    public List<Pagination> getListPag() {
        return listPag;
    }

    public void setListPag(List<Pagination> listPag) {
        this.listPag = listPag;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

}
