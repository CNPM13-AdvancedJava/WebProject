/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao.user;

import model.dbentities.Catalog;
import model.dbentities.ProductDetail;
import java.util.ArrayList;
import java.util.List;
import hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nguyen
 */
public class ProductDAO {

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    public void beginTransaction(){
        session.beginTransaction();
    }
    
    public void closeTransaction(){
        session.getTransaction().commit();
    }

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

    public List<Catalog> getAllCatalog() {
        List<Catalog> lstCatalog = new ArrayList<>();
        try {
            Query query = session.createQuery("from Catalog").setMaxResults(5);
            lstCatalog = query.list();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstCatalog;
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

    public List<ProductDetail> getProductWithType(int typeId){
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
            name = "%"+name+"%";
            query.setParameter("name", name);
            lstProduct = query.list();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstProduct;
    }
}
