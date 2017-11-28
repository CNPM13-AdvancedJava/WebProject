/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao.user;

import model.entities.UserInfo;
import model.dbentities.User;
import java.util.ArrayList;
import java.util.List;
import hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import util.Constant;

/**
 *
 * @author Linh
 */
public class UserDAO {
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    public void beginTransaction(){
        session.beginTransaction();
    }
    
    public void closeTransaction(){
        session.getTransaction().commit();
    }

    public UserInfo login(String email, String pwd) {
        UserInfo userInfo = new UserInfo();
        try {
            String sql = "from User where email = :email";
            Query query = session.createQuery(sql);
            query.setParameter("email", email);
            List lstUser = query.list();
            if (lstUser == null || lstUser.isEmpty()){
                userInfo.setErrorMessage(Constant.ErrorMessage.INVALID_EMAIL);
                return userInfo;
            }
            User user = (User) lstUser.get(0);
            if (!user.getPassword().equals(pwd)){
                userInfo.setErrorMessage(Constant.ErrorMessage.INVALID_PASSWORD);
                return userInfo;
            }
            userInfo.setUser(user);
        } catch (Exception e) {
            System.err.println(e);
        }
        return userInfo;
    }

    public String isEmailExist(String email) {
        String errorMsg = Constant.ErrorMessage.NO_MESSAGE;
        try {
            String sql = "from User where email = :email";
            Query query = session.createQuery(sql);
            query.setParameter("email", email);
            List lstUser = query.list();
            if (lstUser != null && !lstUser.isEmpty()){
                errorMsg = Constant.ErrorMessage.EMAIL_EXIST;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return errorMsg;
    }

    public void register(User user) {
        try {
            session.save(user);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void update(User user) {
        try {
            session.update(user);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public User getUserDetailById(int id) {
        User user = null;
        try {
            user = (User) session.get(User.class, id);
        } catch (Exception e) {
            System.err.println(e);
        }
        return user;
    
    }

    public void updateUser(User user) {
        try {
            session.update(user);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
