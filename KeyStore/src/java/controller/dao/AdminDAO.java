/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import hibernate.util.HibernateTransaction;
import java.util.List;
import model.dbentities.Admin;
import model.entities.AdminInfo;
import model.entities.UserInfo;
import org.hibernate.Query;
import utils.Constant;

/**
 *
 * @author Linh
 */
public class AdminDAO extends HibernateTransaction{
    
    public AdminInfo login(String email, String pwd) {
        AdminInfo info = new AdminInfo();
        try {
            String sql = "from Admin where email = '"+email+"'";
            Query query = session.createQuery(sql);
            List lstAdmin = query.list();
            if (lstAdmin == null || lstAdmin.isEmpty()){
                info.setErrorMessage(Constant.ErrorMessage.INVALID_EMAIL);
                return info;
            }
            Admin admin = (Admin) lstAdmin.get(0);
            if (!admin.getPassword().equals(pwd)){
                info.setErrorMessage(Constant.ErrorMessage.INVALID_PASSWORD);
                return info;
            }
            info.setAdmin(admin);
        } catch (Exception e) {
            System.err.println(e);
        }
        return info;
    }
}
