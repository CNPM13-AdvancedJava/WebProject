/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.user;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import controller.user.UserController;
import entities.UserInfo;
import entities.database.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import util.Constant;

/**
 *
 * @author Linh
 */
public class UserAction extends ActionSupport implements ServletRequestAware{
    
    private HttpServletRequest request;
    private UserController controller;
    
    private UserInfo user;

    public UserAction() {
        controller = new UserController();
    }
    
    public String normalLogin(){
        String email = request.getParameter("txt-email");
        String pwd = request.getParameter("txt-pass");
        user = controller.login(email, pwd);
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

}
