/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.admin;

import com.opensymphony.xwork2.ActionSupport;
import controller.dao.CatalogDAO;
import controller.dao.ProductDAO;
import controller.dao.TypeDAO;
import hibernate.util.HibernateTransaction;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.dbentities.Catalog;
import model.dbentities.ProductDetail;
import model.dbentities.Type;
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
    private ProductDAO productDAO;
    private CatalogDAO catalogDAO;
    private TypeDAO typeDAO;
    
    private List<ProductDetail> lstProduct;
    private List<Catalog> lstCatalog;
    private List<Type> lstType;
    private Product product;

    public ProductAction() {
        transaction = new HibernateTransaction();
        productDAO = new ProductDAO();
        catalogDAO = new CatalogDAO();
        typeDAO = new TypeDAO();
    }
    
    public String getAllProduct(){
        transaction.beginTransaction();
        lstProduct = productDAO.getAllProduct();
        transaction.closeTransaction();
        ProductDetail.getThumnailImage(lstProduct);
        return SUCCESS;
    }
    
    public String prepareData(){
        transaction.beginTransaction();
        lstCatalog = catalogDAO.getAllCatalog();
        lstType = typeDAO.getAllType();
        transaction.closeTransaction();
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

    public List<Type> getLstType() {
        return lstType;
    }

}
