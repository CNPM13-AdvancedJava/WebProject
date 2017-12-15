/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.admin;

import controller.action.base.ActionUploadImage;
import controller.dao.CatalogDAO;
import controller.dao.ProductDAO;
import controller.dao.TypeDAO;
import hibernate.util.HibernateTransaction;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.dbentities.Catalog;
import model.dbentities.ProductDetail;
import model.dbentities.Type;

/**
 *
 * @author Linh
 */
public class ProductAction extends ActionUploadImage {
    private static final String EXTENDED_PATH = "images\\product\\";

    private HttpServletRequest request;
    private HibernateTransaction transaction;
    private ProductDAO productDAO;
    private CatalogDAO catalogDAO;
    private TypeDAO typeDAO;
    
    private List<ProductDetail> lstProduct;
    private List<Catalog> lstCatalog;
    private List<Type> lstType;
    private ProductDetail product;

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
    
    public String deleteProduct(){
        String productId = request.getParameter("productId");
        try {
            transaction.beginTransaction();
            int id = Integer.parseInt(productId);
            productDAO.deleteProduct(id);
        }
        catch (Exception e){
            transaction.rollback();
            System.err.println(e);
        }
        finally {
            transaction.closeTransaction();
        }
        return SUCCESS;
    }
    
    public String getProductDetail(){
        String productId = request.getParameter("productId");
        try {
            transaction.beginTransaction();
            int id = Integer.parseInt(productId);
            product = productDAO.getProductById(id);
        }
        catch (Exception e){
            transaction.rollback();
            System.err.println(e);
        }
        finally {
            transaction.closeTransaction();
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

    public ProductDetail getProduct() {
        return product;
    }

    public List<Type> getLstType() {
        return lstType;
    }

    @Override
    protected String extendedPathString() {
        return EXTENDED_PATH;
    }

}
