/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class UserController {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    public List<Userkey> isNameExist(String name){
        Transaction transaction = null;
        List<Userkey> listUserkey = new ArrayList<Userkey>();
        try {            
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Userkey where user_name = :name");
            query.setParameter("name", name);
            listUserkey = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUserkey;
    }
    
    public List<Userkey> register(Userkey user) {
        List<Userkey> listUser = new ArrayList<Userkey>();
        try {       
            session.save(user); 
            Query query = session.createQuery("from Userkey order by user_name desc");
            listUser = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {            
            session.getTransaction().rollback();
        }
        return listUser;
    }
    
    public List<Userkey> getAllUser() {
    
        List<Userkey> listUser = new ArrayList<Userkey>();
        try{
        session.beginTransaction();
        Query query = session.createQuery("from Userkey order by user_name desc");
        listUser = query.list();
        session.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }
    
    public Userkey getUserById(int userId){
        Userkey user = new Userkey();
        try{
        session.beginTransaction();        
        user = (Userkey) session.get(Userkey.class, userId);
        session.getTransaction().commit();
        } catch (Exception ex) {
        }
        return user;
    }
}
