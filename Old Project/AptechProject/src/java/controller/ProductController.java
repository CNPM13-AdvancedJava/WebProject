/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Catalog;
import entities.Gametype;
import entities.Product;
import entities.ProductKey;
import entities.Saled;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Linh
 */
public class ProductController {

    private Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    public List<Product> isNameExist(String name){
        Transaction transaction = null;
        List<Product> listProduct = new ArrayList<Product>();
        try {            
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Product where product_name = :name");
            query.setParameter("name", name);
            listProduct = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProduct;
    }
    
    public List<Saled> getAnotherSale() {
        List<Saled> listSaled = new ArrayList<Saled>();
        try {            
            Query query = session.createQuery("from Saled");
            listSaled = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSaled;
    } 
    
    public List<Saled> getSale() {
        List<Saled> listSaled = new ArrayList<Saled>();
        try {            
            session.beginTransaction();
            Query query = session.createQuery("from Saled");
            listSaled = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSaled;
    }  
    
    public List<Catalog> getCatalog() {        
        List<Catalog> listCatalog = new ArrayList<Catalog>();
        try {            
            Query query = session.createQuery("from Catalog");
            listCatalog = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCatalog;
    }  
    
    public List<Gametype> getGametype() {        
        List<Gametype> listGametype = new ArrayList<Gametype>();
        try {            
            Query query = session.createQuery("from Gametype");
            listGametype = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGametype;
    }  
   
    public List<Product> getProduct() {
        List<Product> listProduct = new ArrayList<Product>();
        try {            
            Query query = session.createQuery("from Product order by productName");
            listProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProduct;
    }    

    public List<Product> getAllProduct() {
        Transaction transaction = null;
        List<Product> listProduct = new ArrayList<Product>();
        try {          
            transaction = session.beginTransaction();  
            Query query = session.createQuery("from Product order by productName");
            listProduct = query.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProduct;
    } 
    
    public List<Product> addProduct(Product product) {     
        List<Product> listProduct = new ArrayList<Product>();
        try {            
            session.save(product); 
            Query query = session.createQuery("from Product order by productName");
            listProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {            
            session.getTransaction().rollback();
        }
        return listProduct;
    }

    public List<Product> addKey(ProductKey key) {
        List<Product> listProduct = new ArrayList<>();
        session.beginTransaction();
        try {
            session.save(key);
            Query query = session.createQuery("from Product order by productName");
            listProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return listProduct;
    }

    public List<Product> deleteProduct(int productId) {
        List<Product> listProduct = new ArrayList<Product>();
        try {
            Product product = (Product) session.get(Product.class, productId);
            session.delete(product);
            Query query = session.createQuery("from Product order by productName");
            listProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();            
        }
        return listProduct;
    }

    public List<Product> deleteKey(int productKeyId) {
        List<Product> listProduct = new ArrayList<>();
        Transaction transaction = session.getTransaction();
        try {
            ProductKey key = (ProductKey) session.get(ProductKey.class, productKeyId);
            session.delete(key);
            Query query = session.createQuery("from Product order by productName");
            listProduct = query.list();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return listProduct;
    }

    public List<ProductKey> getListKeyByID(int ID){
        List<ProductKey> listKey = new ArrayList<>();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery("from ProductKey where product_id = :id");
            query.setParameter("id", ID);
            listKey = query.list();
            transaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return listKey;
    }
    
    public Product getProductByID(int productId) {
        Product product = new Product();
        try {
            product = (Product) session.get(Product.class, productId); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return product;
    }
    
    public List<Gametype> getListGametype(){
        List<Gametype> listGametype = new ArrayList<Gametype>();
        Transaction transaction = null;
        try {     
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Gametype");
            listGametype = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGametype;
    }

    public List<Product> updateProduct(Product product) {
        List<Product> listProduct = new ArrayList<Product>();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(product);
            Query query = session.createQuery("from Product order by productName");
            listProduct = query.list();
            transaction.commit();
        } catch (Exception e) {           
            transaction.rollback();
        }
        return listProduct;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
    
}
