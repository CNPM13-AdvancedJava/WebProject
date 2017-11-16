/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import controller.ControllerSearch;
import entities.Pagination;
import entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Nguyen
 */
public class ActionSearch extends ActionSupport implements ServletRequestAware{
    private Product product;
    private ControllerSearch controller;
    private HttpServletRequest request;
    private List<Product> lstProduct = new ArrayList<Product>();
    private String searchValue;
    private int gameId;
    private Pagination pag = new Pagination();
    private List<Pagination> listPag = new ArrayList<Pagination>();
    int n = 18;
    
    public ActionSearch() {
        controller = new ControllerSearch();
    }
    
    public String getListFind()
    {       
        searchValue = request.getParameter("txt-searchValue");
        int i = 1;
        listPag = pag.getListPagging(controller.SearchProduct(searchValue).size(), n);
        lstProduct = controller.lstSearchProduct(searchValue,(n * (i - 1)), n);
        if(lstProduct.size()!=0)
        {
            return SUCCESS;
        }
        else{
            return ERROR;
        }
    } 
    
    public String getListFindbyGametype(){
        gameId = Integer.parseInt(request.getParameter("gameId"));
        int i = 1;
        listPag = pag.getListPagging(controller.SearchProductbyGametype(gameId).size(), n);
        lstProduct = controller.lstSearchProductbyGametype(gameId,(n * (i - 1)), n);
        if(lstProduct.size()!=0)
        {
            return SUCCESS;
        }
        else{
            return ERROR;
        }
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ControllerSearch getController() {
        return controller;
    }

    public void setController(ControllerSearch controller) {
        this.controller = controller;
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

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
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

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
          
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }
    
}
