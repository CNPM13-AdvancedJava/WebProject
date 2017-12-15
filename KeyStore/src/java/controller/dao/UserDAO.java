/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import hibernate.util.HibernateTransaction;
import java.util.ArrayList;
import model.entities.UserInfo;
import model.dbentities.User;
import java.util.List;
import model.entities.UserDetail;
import org.hibernate.Query;
import utils.Constant;

/**
 *
 * @author Linh
 */
public class UserDAO extends HibernateTransaction {

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

    public List<User> getAllUser() {
        List<User> lstUser = new ArrayList<>();
        try {
            String sql = "from User Order by userName DESC";
            Query query = session.createQuery(sql);
            List lst = query.list();
            if (lst != null && !lst.isEmpty()){
                lstUser.addAll(lst);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstUser;
    }
    
}
