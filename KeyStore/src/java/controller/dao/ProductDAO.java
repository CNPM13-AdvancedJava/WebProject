/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import hibernate.util.HibernateTransaction;
import model.dbentities.Catalog;
import model.dbentities.ProductDetail;
import java.util.ArrayList;
import java.util.List;
import model.dbentities.ProductImage;
import model.dbentities.ProductKey;
import org.hibernate.Query;

/**
 *
 * @author Linh
 */
public class ProductDAO extends HibernateTransaction {

    public List<ProductDetail> getAllProduct() {
        List<ProductDetail> lstProduct = new ArrayList<>();
        try {
            Query query = session.createQuery("from ProductDetail");
            lstProduct = query.list();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstProduct;
    }

    public List<ProductDetail> get4NewestProduct() {
        List<ProductDetail> lstProduct = new ArrayList<>();
        try {
            Query query = session.createQuery("from ProductDetail Order by releaseTime DESC").setMaxResults(4);
            lstProduct = query.list();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstProduct;
    }

    public List<ProductDetail> get5MostViewProduct() {
        List<ProductDetail> lstProduct = new ArrayList<>();
        try {
            Query query = session.createQuery("from ProductDetail Order by viewedNumber DESC").setMaxResults(5);
            lstProduct = query.list();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstProduct;
    }

    public ProductDetail getProductById(int id) {
        ProductDetail product = null;
        try {
            product = (ProductDetail) session.get(ProductDetail.class, id);
        } catch (Exception e) {
            System.err.println(e);
        }
        return product;
    }

    public List<ProductDetail> getProductWithType(int typeId) {
        List<ProductDetail> lstProduct = new ArrayList<>();
        try {
            String sql = "from ProductDetail where type.typeId = :type";
            Query query = session.createQuery(sql);
            query.setParameter("type", typeId);
            lstProduct = query.list();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstProduct;
    }

    public List<ProductDetail> getProductByName(String name) {
        List<ProductDetail> lstProduct = new ArrayList<>();
        try {
            String sql = "from ProductDetail where productName like :name";
            Query query = session.createQuery(sql);
            name = "%" + name + "%";
            query.setParameter("name", name);
            lstProduct = query.list();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstProduct;
    }

    public void deleteProduct(int id) {
        ProductDetail product = (ProductDetail) session.get(ProductDetail.class, id);
        Query query = session.createQuery("from ProductKey where productDetail.productId = :id");
        query.setParameter("id", id);

        ProductKeyDAO productKeyDAO = new ProductKeyDAO();
        ProductImageDAO productImageDAO = new ProductImageDAO();
        
        for (Object key : query.list()) {
            productKeyDAO.deleteKey((ProductKey) key);
        }

        Query query1 = session.createQuery("from ProductImage where productDetail.productId = :id");
        query1.setParameter("id", id);
        for (Object img : query1.list()) {
            productImageDAO.deleteImage((ProductImage) img);
        }

        session.delete(product);
    }

    public void saveOrUpdateProduct(ProductDetail product) {
        session.saveOrUpdate(product);
    }
}
