/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import entities.UserInfo;
import entities.database.User;
import java.util.ArrayList;
import java.util.List;
import model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import util.Constant;

/**
 *
 * @author Linh
 */
public class UserController {
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public UserInfo login(String email, String pwd) {
        UserInfo userInfo = new UserInfo();
        try {
            session.beginTransaction();
            String sql = "from User where email = :email";
            Query query = session.createQuery(sql);
            query.setParameter("email", email);
            List lstUser = query.list();
            if (lstUser == null || lstUser.isEmpty()){
                userInfo.setErrorMessage(Constant.ErrorMessage.INVALID_EMAIL);
                session.getTransaction().commit();
                return userInfo;
            }
            User user = (User) lstUser.get(0);
            if (!user.getPassword().equals(pwd)){
                userInfo.setErrorMessage(Constant.ErrorMessage.INVALID_PASSWORD);
                session.getTransaction().commit();
                return userInfo;
            }
            userInfo.setUser(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        }
        return userInfo;
    }

    public String isEmailExist(String email) {
        String errorMsg = Constant.ErrorMessage.NO_MESSAGE;
        try {
            session.beginTransaction();
            String sql = "from User where email = :email";
            Query query = session.createQuery(sql);
            query.setParameter("email", email);
            List lstUser = query.list();
            if (lstUser != null && !lstUser.isEmpty()){
                errorMsg = Constant.ErrorMessage.EMAIL_EXIST;
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        }
        return errorMsg;
    }

    public void register(User user) {
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
