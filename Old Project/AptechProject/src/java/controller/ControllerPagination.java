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

/**
 *
 * @author Nguyen
 */
public class ControllerPagination {

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
    
    public List<Product> getProduct() {
        List<Product> lstProduct = new ArrayList<Product>();
        try {  
            session.beginTransaction();
            Query query = session.createQuery("from Product");
            lstProduct = query.list();           
        } catch (Exception e) {
        }
        return lstProduct;
    }
    
    public List<Product> getListProduct(int first, int count) {
        List<Product> lstPro = new ArrayList<Product>();
        try {         
            Query qr = session.createQuery("from Product");
            qr.setFirstResult(first);
            qr.setMaxResults(count);
            lstPro = qr.list();
            session.getTransaction().commit();
        } catch (Exception e) {
        }
        return lstPro;

    }

}
