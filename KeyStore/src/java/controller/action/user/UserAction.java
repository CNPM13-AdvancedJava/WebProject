/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.user;

import com.opensymphony.xwork2.ActionSupport;
import controller.dao.UserDAO;
import hibernate.util.HibernateTransaction;
import model.entities.UserInfo;
import model.dbentities.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.entities.UserDetail;
import org.apache.struts2.interceptor.ServletRequestAware;
import util.Constant;
import util.Util;

/**
 *
 * @author Linh
 */
public class UserAction extends ActionSupport implements ServletRequestAware{
    
    private HttpServletRequest request;
    
    private HibernateTransaction transaction;
    private UserDAO dao;
    
    private UserInfo user;
    private UserDetail detail;

    public UserAction() {
        transaction = new HibernateTransaction();
        dao = new UserDAO();
    }
    
    public String cardCharging(){
        String id = request.getParameter("id");
        String cardType = request.getParameter("cardType");
        String serial = request.getParameter("serial");
        String pin = request.getParameter("pin");
        Double money = 500000.0;
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        try {
            int uId = Integer.parseInt(id);
            if (userId.equals(uId)){
                transaction.beginTransaction();
                User userDetail = dao.getUserDetailById(uId);
                userDetail.setMoney(money + userDetail.getMoney());
                detail = new UserDetail(userDetail);
                dao.update(userDetail);
                transaction.closeTransaction();
                HttpSession session = request.getSession();
                session.setAttribute("userId", userDetail.getUserId());
                session.setAttribute("userName", userDetail.getUserName());
                session.setAttribute("currentMoney", userDetail.getMoney());
                return SUCCESS;
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
        return ERROR;
    }
    
    public String normalLogin(){
        String email = request.getParameter("txt-email");
        String pwd = request.getParameter("txt-pass");
        transaction.beginTransaction();
        user = dao.login(email, pwd);
        transaction.closeTransaction();
        if (user.getErrorMessage().equalsIgnoreCase(Constant.ErrorMessage.NO_MESSAGE)) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getUser().getUserId());
            session.setAttribute("userName", user.getUser().getUserName());
            session.setAttribute("currentMoney", user.getUser().getMoney());
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
    
    public String normalRegister(){
        String email = request.getParameter("email");
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String cfmPwd = request.getParameter("cfmPwd");
        String gender = request.getParameter("gender");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        
        user = new UserInfo();
        String errorMessage = Util.validatePassword(pwd, cfmPwd);
        if (!errorMessage.equals(Constant.ErrorMessage.NO_MESSAGE)){
            user.setErrorMessage(errorMessage);
            return ERROR;
        }
        user.setUser(new User(userName, pwd, email, phoneNumber, gender, address, dateOfBirth));
        errorMessage = Util.validateUser(user.getUser());
        if (!errorMessage.equals(Constant.ErrorMessage.NO_MESSAGE)){
            user.setErrorMessage(errorMessage);
            return ERROR;
        }
        
        transaction.beginTransaction();
        errorMessage = dao.isEmailExist(email);
        if (!errorMessage.equals(Constant.ErrorMessage.NO_MESSAGE)){
            user.setErrorMessage(errorMessage);
            return ERROR;
        }
        
        dao.register(user.getUser());
        transaction.closeTransaction();
        
        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getUser().getUserId());
        session.setAttribute("userName", user.getUser().getUserName());
        session.setAttribute("currentMoney", user.getUser().getMoney());
        return SUCCESS;
    }
    
    public String getUserById(){
        String id = request.getParameter("id");
        String isChange = request.getParameter("isChange");
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        try {
            int uId = Integer.parseInt(id);
            if (userId.equals(uId)){
                transaction.beginTransaction();
                User userDetail = dao.getUserDetailById(uId);
                detail = new UserDetail(userDetail);
                transaction.closeTransaction();
                if (isChange != null && isChange.equals("1")){
                    return INPUT;
                }
                HttpSession session = request.getSession();
                session.setAttribute("userId", userDetail.getUserId());
                session.setAttribute("userName", userDetail.getUserName());
                session.setAttribute("currentMoney", userDetail.getMoney());
                return SUCCESS;
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
        return ERROR;
    }
    
    
    public String changePass() {
        String result = ERROR;
        String id = request.getParameter("id");
        String curPass = request.getParameter("curPass");
        String newPass = request.getParameter("newPass");
        String cfmPass = request.getParameter("cfmPass");
        Integer sessionUID = (Integer) request.getSession().getAttribute("userId");
        int userId = 0;
        try {
            userId = Integer.parseInt(id);
        } catch (Exception e) {
            System.err.println(e);
        }
        transaction.beginTransaction();
        User userDetail = dao.getUserDetailById(userId);
        user = new UserInfo();
        detail = new UserDetail(userDetail);
        if (userId != sessionUID){
            transaction.closeTransaction();
            return result;
        }
        String errorMessage = Util.validatePassword(newPass, cfmPass);
        if (!errorMessage.equals(Constant.ErrorMessage.NO_MESSAGE)){
            user.setErrorMessage(errorMessage);
            transaction.closeTransaction();
            return result;
        }
        
        if (userDetail.getPassword() != null && userDetail.getPassword().equals(curPass)){
            userDetail.setPassword(newPass);
            dao.update(userDetail);
            user.setSuccessMessage(Constant.SuccessMessage.CHANGE_PASSWORD_SUCCESS);
            result = SUCCESS;
        }
        else {
            user.setErrorMessage(Constant.ErrorMessage.INVALID_PASSWORD);
        }
        transaction.closeTransaction();
        return result;
    }
    
    public String updateUserInfo(){
        String userId = request.getParameter("userId");
        String email = request.getParameter("email");
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        
        detail = new UserDetail(userId, email, userName, dateOfBirth, phoneNumber, address);
        user = new UserInfo();
        user.setUser(new User(userId, userName, email, phoneNumber, address, dateOfBirth));
        String errorMessage = Util.validateUser(user.getUser());
        if (!errorMessage.equals(Constant.ErrorMessage.NO_MESSAGE)){
            user.setErrorMessage(errorMessage);
            return ERROR;
        }
        
        transaction.beginTransaction();
        User u = dao.getUserDetailById(Integer.parseInt(userId));
        u.setUserName(userName);
        u.setDateOfBirth(Util.format(dateOfBirth));
        u.setPhoneNumber(phoneNumber);
        u.setAddress(address);
        dao.update(u);
        detail = new UserDetail(u);
        user.setSuccessMessage(Constant.SuccessMessage.UPDATE_INFO_SUCCESS);
        transaction.closeTransaction();
        
        HttpSession session = request.getSession();
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("userName", u.getUserName());
        session.setAttribute("currentMoney", u.getMoney());
        return SUCCESS;
    }
    
    public String logout(){
        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        session.removeAttribute("userName");
        session.removeAttribute("currentMoney");
        return SUCCESS;
    }
    
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        request = hsr;
    }

    public UserInfo getUser() {
        return user;
    }

    public UserDetail getDetail() {
        return detail;
    }

}
