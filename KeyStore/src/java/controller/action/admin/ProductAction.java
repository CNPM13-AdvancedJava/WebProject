/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.admin;

import com.opensymphony.xwork2.ActionSupport;
import controller.dao.ProductDAO;
import hibernate.util.HibernateTransaction;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.dbentities.Catalog;
import model.dbentities.ProductDetail;
import model.entities.Page;
import model.entities.Product;
import org.apache.struts2.interceptor.ServletRequestAware;
import util.Util;

/**
 *
 * @author Linh
 */
public class ProductAction extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;
    private HibernateTransaction transaction;
    private ProductDAO dao;
    
    private List<ProductDetail> lstProduct;
    private List<Catalog> lstCatalog;
    private Product product;

    private final int pageSize = 18;
    private int totalPage;
    private int totalProduct;
    private List<Page> lstPage;

    public ProductAction() {
        transaction = new HibernateTransaction();
        dao = new ProductDAO();
    }
    
    public String getAllProduct(){
        int curPage = 1;
        String curPageStr = request.getParameter("page");
        try {
            curPage = Integer.parseInt(curPageStr);
        } catch (Exception e) {

        }
        transaction.beginTransaction();
        lstProduct = dao.getAllProduct();
        totalProduct = lstProduct.size();
        transaction.closeTransaction();
        totalPage = Util.getTotalPage(lstProduct.size(), pageSize);
        lstProduct = Util.getPagitation(lstProduct, curPage, pageSize);
        lstPage = Page.getPageList(totalPage, curPage);
        ProductDetail.getThumnailImage(lstProduct);
        if (curPageStr != null){
            return "page";
        }
        return SUCCESS;
    }
    
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        request = hsr;
    }

    public List<ProductDetail> getLstProduct() {
        return lstProduct;
    }

    public List<Catalog> getLstCatalog() {
        return lstCatalog;
    }

    public Product getProduct() {
        return product;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalProduct() {
        return totalProduct;
    }

    public List<Page> getLstPage() {
        return lstPage;
    }
    
}
