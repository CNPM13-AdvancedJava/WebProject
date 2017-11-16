/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.user;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import controller.dao.user.UserDAO;
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
    private UserDAO dao;
    
    private UserInfo user;
    private UserDetail detail;

    public UserAction() {
        dao = new UserDAO();
    }
    
    public String normalLogin(){
        String email = request.getParameter("txt-email");
        String pwd = request.getParameter("txt-pass");
        dao.beginTransaction();
        user = dao.login(email, pwd);
        dao.closeTransaction();
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
        
        dao.beginTransaction();
        errorMessage = dao.isEmailExist(email);
        if (!errorMessage.equals(Constant.ErrorMessage.NO_MESSAGE)){
            user.setErrorMessage(errorMessage);
            return ERROR;
        }
        
        dao.register(user.getUser());
        dao.closeTransaction();
        
        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getUser().getUserId());
        session.setAttribute("userName", user.getUser().getUserName());
        session.setAttribute("currentMoney", user.getUser().getMoney());
        return SUCCESS;
    }
    
    public String getUserById(){
        String id = request.getParameter("id");
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        try {
            int uId = Integer.parseInt(id);
            if (userId.equals(uId)){
                dao.beginTransaction();
                User userDetail = dao.getUserDetailById(uId);
                detail = new UserDetail(userDetail);
                dao.closeTransaction();
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
        dao.beginTransaction();
        User userDetail = dao.getUserDetailById(userId);
        user = new UserInfo();
        detail = new UserDetail(userDetail);
        if (userId != sessionUID){
            dao.closeTransaction();
            return result;
        }
        String errorMessage = Util.validatePassword(newPass, cfmPass);
        if (!errorMessage.equals(Constant.ErrorMessage.NO_MESSAGE)){
            user.setErrorMessage(errorMessage);
            dao.closeTransaction();
            return result;
        }
        
        if (userDetail.getPassword() != null && userDetail.getPassword().equals(curPass)){
            userDetail.setPassword(newPass);
            dao.updateUser(userDetail);
            user.setSuccessMessage(Constant.SuccessMessage.CHANGE_PASSWORD_SUCCESS);
            result = SUCCESS;
        }
        else {
            user.setErrorMessage(Constant.ErrorMessage.INVALID_PASSWORD);
        }
        dao.closeTransaction();
        return result;
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
