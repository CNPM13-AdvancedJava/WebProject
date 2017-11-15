/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.user;

import com.opensymphony.xwork2.ActionSupport;
import controller.dao.user.ProductController;
import model.entities.Page;
import model.entities.Product;
import model.dbentities.Catalog;
import model.dbentities.ProductDetail;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import util.Util;

public class ProductAction extends ActionSupport implements ServletRequestAware {

    private ProductController controller;
    private HttpServletRequest request;

    private List<ProductDetail> lstProduct;
    private List<Catalog> lstCatalog;
    public Product product;

    private final int pageSize = 18;
    private int totalPage;
    private List<Page> lstPage;

    public ProductAction() {
        controller = new ProductController();
    }

    public String getBanner() {
        controller.beginTransaction();
        lstProduct = controller.get4NewestProduct();
        controller.closeTransaction();
        ProductDetail.getThumnailImage(lstProduct);
        lstProduct.get(0).setBannerStatus("active");
        return SUCCESS;
    }

    public String getTop5() {
        controller.beginTransaction();
        lstProduct = controller.get5MostViewProduct();
        controller.closeTransaction();
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
        controller.beginTransaction();
        lstProduct = controller.getAllProduct();
        controller.closeTransaction();
        totalPage = Util.getTotalPage(lstProduct.size(), pageSize);
        lstProduct = Util.getPagitation(lstProduct, curPage, pageSize);
        lstPage = Page.getPageList(totalPage, curPage);
        ProductDetail.getThumnailImage(lstProduct);
        return SUCCESS;
    }

    public String getMenu() {
        controller.beginTransaction();
        lstCatalog = controller.getAllCatalog();
        controller.closeTransaction();
        return SUCCESS;
    }

    public String getProductDetail() {
        String id = request.getParameter("productId");
        int productId = 0;
        try {
            productId = Integer.parseInt(id);
        } catch (Exception e) {
        }
        controller.beginTransaction();
        ProductDetail detail = controller.getProductById(productId);
        controller.closeTransaction();
        ProductDetail.getThumnailImage(detail);
        product = new Product(detail);
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

}
