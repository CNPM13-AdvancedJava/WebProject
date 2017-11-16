/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Allorder;
import entities.Product;
import entities.Userkey;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nguyen
 */
public class ControllerThanhToan {   
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    public Product getProductbyId(int productId)
    {
        Product product = new Product();
        try {
            session.beginTransaction();
            product = (Product) session.get(Product.class, productId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return product;
    }
    public List<Userkey> getUserbyName(String userName)
    {
        List<Userkey> lstUser = new ArrayList<Userkey>();
        try {
            session.beginTransaction();
            String sql = "from Userkey where user_name = :username";
            Query query = session.createQuery(sql);
            query.setParameter("username", userName);
            lstUser = query.list();           
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lstUser;
    }
    public boolean updateMoney(int userId,int tien)
    {
        boolean check =true;
        try {
            String sql = "UPDATE Userkey set money = :money Where user_id = :userId";
            Query query = session.createQuery(sql);
            query.setParameter("money", tien);
            query.setParameter("userId", userId);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
            check = false;
        }
        return check;
    }
    
    public List<Userkey> getUserGH(String userName)
    {
        List<Userkey> lstUser = new ArrayList<Userkey>();
        try {
            session.beginTransaction();
            String sql = "from Userkey where user_name = :username";
            Query query = session.createQuery(sql);
            query.setParameter("username", userName);
            lstUser = query.list();           
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lstUser;
    }
    public boolean updateMoneyGH(int userId,int tien)
    {
        boolean check =true;
        try {
            String sql = "UPDATE Userkey set money = :money Where user_id = :userId";
            Query query = session.createQuery(sql);
            query.setParameter("money", tien);
            query.setParameter("userId", userId);
            query.executeUpdate();          
        } catch (Exception e) {
            e.getStackTrace();
            check = false;
        }
        return check;
    }
    public boolean deleteOrderbyuserId(int userId,String stt){
        boolean check = true;
        try {
            String sql = "UPDATE Allorder set order_pstatus = :stt Where user_id = :userId";
            Query query = session.createQuery(sql);
            query.setParameter("userId", userId);
            query.setParameter("stt", stt);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
            check = false;
        }
        return check;
    }
    
    public List<Userkey> getUserbyPay(String userName){
        List<Userkey> lstUser = new ArrayList<Userkey>();
        try {
            session.beginTransaction();
            String sql = "from Userkey where user_name = :user";
            Query query = session.createQuery(sql);
            query.setParameter("user", userName);
            lstUser = query.list();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lstUser;
    }    
    public boolean deleteOrderbyuserIdPay(int userId,String stt){
        boolean check = true;
        try {
            String sql = "UPDATE Allorder set order_pstatus = :stt Where user_id = :userId";
            Query query = session.createQuery(sql);
            query.setParameter("userId", userId);
            query.setParameter("stt", stt);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
            check = false;
        }
        return check;
    }
}
