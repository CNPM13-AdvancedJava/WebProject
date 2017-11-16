/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Allorder;
import entities.Method;
import entities.Product;
import entities.Userkey;
import java.util.ArrayList;
import java.util.List;
import model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class ControllerGioHang {

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public List<Userkey> checkEmail(String email) {
        List<Userkey> lstEmail = new ArrayList<Userkey>();
        try {
            session.beginTransaction();
            String sql = "from Userkey where user_name = :username";
            Query query = session.createQuery(sql);
            query.setParameter("username", email);
            lstEmail = query.list();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lstEmail;
    }

    public Method getMethodById(int methodId) {
        Method method = new Method();
        try {
            method = (Method) session.get(Method.class, methodId);
        } catch (Exception ex) {
        }
        return method;
    }
    
    public Product getProductById(int productId) {
        Product product = new Product();
        try {
            product = (Product) session.get(Product.class, productId);
        } catch (Exception ex) {
        }
        return product;
    }

    public boolean addOrder(Allorder order) {
        boolean kq = true;
        try {
            session.save(order);
        } catch (Exception e) {
            kq = false;
            e.printStackTrace();
        }
        return kq;
    }

    public Product getProById(int productId) {
        Product product = new Product();
        try {
            product = (Product) session.get(Product.class, productId);
        } catch (Exception ex) {
        }
        return product;
    }

    public List<Product> getProductRef(int gameType,int proId) {
        List<Product> listProduct = new ArrayList<Product>();
        try {
            Query query = session.createQuery("From Product Where gametype_id = :gametype And product_id != :proId").setMaxResults(6);
            query.setParameter("gametype", gameType);
            query.setParameter("proId", proId);
            listProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProduct;
    }

    public List<Userkey> checkEmailbyGH(String email) {
        List<Userkey> lstEmail = new ArrayList<Userkey>();
        try {
            session.beginTransaction();
            String sql = "from Userkey where user_name = :username";
            Query query = session.createQuery(sql);
            query.setParameter("username", email);
            lstEmail = query.list();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lstEmail;
    }

    public List<Allorder> getListOrder(int userId,String stt) {
        List<Allorder> lstOrder = new ArrayList<Allorder>();
        try {
            String sql = "from Allorder Where order_pstatus = :pst AND user_id = :userId";
            Query query = session.createQuery(sql);
            query.setParameter("userId", userId);
            query.setParameter("pst", stt);
            lstOrder = query.list();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lstOrder;
    }

    public List<Product> getAllProduct() {
        List<Product> lstProduct = new ArrayList<Product>();
        try {
            Query query = session.createQuery("from Product");
            lstProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
        }
        return lstProduct;
    }

    public List<Allorder> DeleteGioHang(int orderId, int userId,String stt) {
        boolean check = true;
        List<Allorder> lstOrder = new ArrayList<Allorder>();
        try {
            session.beginTransaction();
            Allorder order = (Allorder) session.get(Allorder.class, orderId);
            session.delete(order);
            String sql = "from Allorder Where user_id = :userId And order_pstatus = :stt";
            Query query = session.createQuery(sql);
            query.setParameter("userId", userId);
            query.setParameter("stt", stt);
            lstOrder = query.list();
        } catch (Exception e) {
            e.getStackTrace();
            session.getTransaction().rollback();
        }
        return lstOrder;
    }

    public List<Product> getAllProductDelete() {
        List<Product> lstProduct = new ArrayList<Product>();
        try {
            Query query = session.createQuery("from Product");
            lstProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
        }
        return lstProduct;
    } 
}
