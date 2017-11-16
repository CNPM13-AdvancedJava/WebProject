/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Userkey;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nguyen
 */
public class ControllerUser {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    public List<Userkey> getAllUser(String userName){
        List<Userkey> lstUser = new ArrayList<Userkey>();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Userkey where user_name = :username");
            query.setParameter("username", userName);
            lstUser = query.list();            
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lstUser;
    }
    public Userkey getUserbyId(int userId){
        Userkey user = new Userkey();
        try {
            user = (Userkey) session.get(Userkey.class, userId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return user;
    }
    public Userkey getUserbyIdinChange(int userId){
        Userkey user = new Userkey();
        try {
            session.beginTransaction();
            user = (Userkey) session.get(Userkey.class, userId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return user;
    }
    public Userkey checkNullUser(int userId){
        Userkey user = new Userkey();
        try {
            session.beginTransaction();
            user = (Userkey) session.get(Userkey.class, userId);           
        } catch (Exception e) {
            e.getStackTrace();
        }
        return user;
    }
    public Userkey updateUser(String phonenum,String gender,String address,Date birth,int userId){
        Userkey user = new Userkey();
        try {
            String sql = "UPDATE Userkey set user_phonenum = :phonenum,user_gender = :gender,user_address = :address,user_dateofbirth = :birth"
                    + " Where user_id = :userId";
            Query query = session.createQuery(sql);
            query.setParameter("phonenum", phonenum);  
            query.setParameter("gender", gender);
            query.setParameter("address", address);
            query.setParameter("birth", birth);
            query.setParameter("userId", userId);           
            query.executeUpdate();   
            user = (Userkey) session.get(Userkey.class, userId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();        
        }
        return user;
    }
    public List<Userkey> getUseroldUpdate(String userName){
        List<Userkey> lstUser = new ArrayList<Userkey>();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Userkey where user_name = :user ");
            query.setParameter("user", userName);
            
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lstUser;
    }
    public Userkey getUserbyIdoldUpdate(int userId){
        Userkey user = new Userkey();
        try {
            user = (Userkey) session.get(Userkey.class, userId);  
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return user;
    }
    
    public List<Userkey> getPassChange(String pass,int userId)
    {
        List<Userkey> lstUser = new ArrayList<Userkey>();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Userkey where user_id = :userId and user_password = :pass");
            query.setParameter("userId", userId);
            query.setParameter("pass", pass);
            lstUser = query.list();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lstUser;
    }
    
    public Userkey changePass(String newpass,int userId){
        Userkey user = new Userkey();
        try {
            String sql = "UPDATE Userkey set user_password = :pass Where user_id = :userId";
            Query query = session.createQuery(sql);
            query.setParameter("pass", newpass);
            query.setParameter("userId", userId);
            query.executeUpdate();
            user = (Userkey) session.get(Userkey.class, userId); 
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return user;
    }
}
