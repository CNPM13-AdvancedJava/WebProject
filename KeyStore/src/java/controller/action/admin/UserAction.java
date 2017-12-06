/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.admin;

import com.opensymphony.xwork2.ActionSupport;
import controller.dao.UserDAO;
import hibernate.util.HibernateTransaction;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.dbentities.User;
import model.entities.UserDetail;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Linh
 */
public class UserAction extends ActionSupport implements ServletRequestAware {
    
    private HttpServletRequest request;
    
    private final HibernateTransaction transaction = new HibernateTransaction();
    private final UserDAO userDAO = new UserDAO();
    
    private List<UserDetail> lstUser;
    
    public String getAllUser(){
        transaction.beginTransaction();
        List<User> lst = userDAO.getAllUser();
        transaction.closeTransaction();
        lstUser = new ArrayList<>();
        for (User user : lst){
            lstUser.add(new UserDetail(user));
        }
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    public List<UserDetail> getLstUser() {
        return lstUser;
    }
    
}
