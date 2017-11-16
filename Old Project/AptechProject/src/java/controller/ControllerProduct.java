/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Product;
import java.util.ArrayList;
import java.util.List;
import model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nguyen
 */
public class ControllerProduct {
    Session session  = HibernateUtil.getSessionFactory().getCurrentSession();
    public List<Product> getAllProduct()
    {
        List<Product> lstProduct = new ArrayList<Product>();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Product");
            lstProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
        }
        return lstProduct;            
    }
    public List<Product> getBanner()
    {
        List<Product> lstProduct = new ArrayList<Product>();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Product Order by linkbanner DESC").setMaxResults(4);
            lstProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
        }
        return lstProduct;            
    }
    public Product getProductById(int productId) {
        Product product = new Product();
        try{
        session.beginTransaction();        
        product = (Product) session.get(Product.class, productId);        
        } catch (Exception ex) {
        }
        return product;
    }
    public List<Product> getTop5() {
        List<Product> lstProduct = new ArrayList<Product>();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Product order by numberview DESC").setMaxResults(5);
            lstProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
        }      
        return lstProduct;
    }
    
    public List<Product> getProductRef(int gameType,int proId){
        List<Product> listProduct = new ArrayList<Product>();
        try {            
            Query query = session.createQuery("From Product Where gametype_id = :gametype And product_id != :proId").setMaxResults(6);
            query.setParameter("gametype", gameType);
            query.setParameter("proId", proId);
            listProduct = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProduct;
    }
    public boolean updateProduct(int numberView,int proId) {
        boolean check = true;
        try {            
            String sql = "UPDATE Product Set numberview = :numberview" + " Where product_id = :productId";
            numberView = numberView +1;
            Query query = session.createQuery(sql);
            query.setParameter("numberview", numberView);
            query.setParameter("productId", proId);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            check = false;
            session.getTransaction().rollback();
        }
        return check;
    } 
    
}
