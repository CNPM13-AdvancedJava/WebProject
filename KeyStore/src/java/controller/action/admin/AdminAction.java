/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.admin;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import controller.dao.AdminDAO;
import hibernate.util.HibernateTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.entities.AdminInfo;
import org.apache.struts2.interceptor.ServletRequestAware;
import utils.Constant;

/**
 *
 * @author Linh
 */
public class AdminAction extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;
    private HibernateTransaction transaction;
    private AdminDAO dao;
    
    private AdminInfo admin;

    public AdminAction() {
        transaction = new HibernateTransaction();
        dao = new AdminDAO();
    }
    
    public String login(){
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");
        transaction.beginTransaction();
        admin = dao.login(email, pwd);
        transaction.closeTransaction();
        if (admin.getErrorMessage().equalsIgnoreCase(Constant.ErrorMessage.NO_MESSAGE)) {
            HttpSession session = request.getSession();
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
    
    public String checkPermission(){
        return SUCCESS;
    }
    
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        request = hsr;
    }

    public AdminInfo getAdmin() {
        return admin;
    }
    
}
