/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Method;
import entities.Allorder;
import entities.Product;
import entities.ProductKey;
import entities.Userkey;
import java.util.ArrayList;
import java.util.List;
import model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Linh
 */
public class OrderController {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    public List<Allorder> getAllOrder() {
    
        List<Allorder> listOrder = new ArrayList<Allorder>();
        try{        
        Query query = session.createQuery("from Allorder");
        listOrder = query.list();
        session.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return listOrder;
    }
    
    public List<Userkey> getAllUser() {
    
        List<Userkey> listUser = new ArrayList<Userkey>();
        try{
        Query query = session.createQuery("from Userkey");
        listUser = query.list();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }
    
    public List<Method> getAllMethod() {
    
        List<Method> listMethod = new ArrayList<Method>();
        try{
        session.beginTransaction();
        Query query = session.createQuery("from Method");
        listMethod = query.list();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return listMethod;
    }
    
    public List<Product> getAllProduct() {
    
        List<Product> listProduct = new ArrayList<Product>();
        try{
        Query query = session.createQuery("from Product");
        listProduct = query.list();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return listProduct;
    }
    
    public List<ProductKey> getAllProductKey() {
    
        List<ProductKey> listKey = new ArrayList<ProductKey>();
        try{
        Query query = session.createQuery("from ProductKey");
        listKey = query.list();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return listKey;
    }
}
