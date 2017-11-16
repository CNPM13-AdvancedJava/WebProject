/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.user;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import controller.dao.user.UserController;
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
    private UserController controller;
    
    private UserInfo user;
    private UserDetail detail;

    public UserAction() {
        controller = new UserController();
    }
    
    public String normalLogin(){
        String email = request.getParameter("txt-email");
        String pwd = request.getParameter("txt-pass");
        controller.beginTransaction();
        user = controller.login(email, pwd);
        controller.closeTransaction();
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
        
        controller.beginTransaction();
        errorMessage = controller.isEmailExist(email);
        if (!errorMessage.equals(Constant.ErrorMessage.NO_MESSAGE)){
            user.setErrorMessage(errorMessage);
            return ERROR;
        }
        
        controller.register(user.getUser());
        controller.closeTransaction();
        
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
                controller.beginTransaction();
                User userDetail = controller.getUserDetailById(uId);
                detail = new UserDetail(userDetail);
                controller.closeTransaction();
                return SUCCESS;
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
        return ERROR;
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
