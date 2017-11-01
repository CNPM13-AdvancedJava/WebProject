/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import entities.database.ProductDetail;
import java.util.ArrayList;
import java.util.List;
import model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nguyen
 */
public class ProductController {

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public List<ProductDetail> getAllProduct() {
        List<ProductDetail> lstProduct = new ArrayList<>();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from ProductDetail");
            lstProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstProduct;
    }

    public List<ProductDetail> get4NewestProduct() {
        List<ProductDetail> lstProduct = new ArrayList<>();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from ProductDetail Order by releaseTime DESC").setMaxResults(4);
            lstProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstProduct;
    }

    public List<ProductDetail> get5MostViewProduct() {
        List<ProductDetail> lstProduct = new ArrayList<>();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from ProductDetail Order by viewedNumber DESC").setMaxResults(5);
            lstProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstProduct;
    }

}
