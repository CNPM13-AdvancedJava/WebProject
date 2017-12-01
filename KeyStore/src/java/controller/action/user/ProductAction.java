/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.user;

import com.opensymphony.xwork2.ActionSupport;
import controller.dao.user.ProductDAO;
import model.entities.Page;
import model.entities.Product;
import model.dbentities.Catalog;
import model.dbentities.ProductDetail;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import util.Util;

public class ProductAction extends ActionSupport implements ServletRequestAware {

    private ProductDAO dao;
    private HttpServletRequest request;

    private List<ProductDetail> lstProduct;
    private List<Catalog> lstCatalog;
    public Product product;

    private final int pageSize = 18;
    private int totalPage;
    private int totalProduct;
    private List<Page> lstPage;

    public ProductAction() {
        dao = new ProductDAO();
    }

    public String getBanner() {
        dao.beginTransaction();
        lstProduct = dao.get4NewestProduct();
        dao.closeTransaction();
        ProductDetail.getThumnailImage(lstProduct);
        lstProduct.get(0).setBannerStatus("active");
        return SUCCESS;
    }

    public String getTop5() {
        dao.beginTransaction();
        lstProduct = dao.get5MostViewProduct();
        dao.closeTransaction();
        ProductDetail.getThumnailImage(lstProduct);
        return SUCCESS;
    }

    public String getPagination() {
        int curPage = 1;
        String curPageStr = request.getParameter("page");
        try {
            curPage = Integer.parseInt(curPageStr);
        } catch (Exception e) {

        }
        dao.beginTransaction();
        lstProduct = dao.getAllProduct();
        totalProduct = lstProduct.size();
        dao.closeTransaction();
        totalPage = Util.getTotalPage(lstProduct.size(), pageSize);
        lstProduct = Util.getPagitation(lstProduct, curPage, pageSize);
        lstPage = Page.getPageList(totalPage, curPage);
        ProductDetail.getThumnailImage(lstProduct);
        if (curPageStr != null){
            return "page";
        }
        return SUCCESS;
    }

    public String getMenu() {
        dao.beginTransaction();
        lstCatalog = dao.getAllCatalog();
        dao.closeTransaction();
        return SUCCESS;
    }

    public String getProductDetail() {
        String id = request.getParameter("productId");
        int productId = 0;
        try {
            productId = Integer.parseInt(id);
        } catch (Exception e) {
        }
        dao.beginTransaction();
        ProductDetail detail = dao.getProductById(productId);
        ProductDetail.getThumnailImage(detail);
        product = new Product(detail);
        List lstRefProduct = dao.getProductWithType(detail.getType().getTypeId());
        dao.closeTransaction();
        lstRefProduct = ProductDetail.getRandomProductFromList(lstRefProduct, 6);
        ProductDetail.getThumnailImage(lstRefProduct);
        product.setLstProduct(lstRefProduct);
        return SUCCESS;
    }
    
    public String findProduct(){
        String name = request.getParameter("name");
        dao.beginTransaction();
        lstProduct = dao.getProductByName(name);
        dao.closeTransaction();
        totalProduct = lstProduct.size();
        ProductDetail.getThumnailImage(lstProduct);
        return SUCCESS;
    }
    
    public String getProductByType(){
        Integer type = null;
        try {
            type = Integer.parseInt(request.getParameter("type"));
        } 
        catch (Exception e){
        }
        dao.beginTransaction();
        if (type == null){
            lstProduct = dao.getAllProduct();
        }
        else {
            lstProduct = dao.getProductWithType(type);
        }
        ProductDetail.getThumnailImage(lstProduct);
        dao.closeTransaction();
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    public List<ProductDetail> getLstProduct() {
        return lstProduct;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<Page> getLstPage() {
        return lstPage;
    }

    public List<Catalog> getLstCatalog() {
        return lstCatalog;
    }

    public Product getProduct() {
        return product;
    }

    public int getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(int totalProduct) {
        this.totalProduct = totalProduct;
    }

}
