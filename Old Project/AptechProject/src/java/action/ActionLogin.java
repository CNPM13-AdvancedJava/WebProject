/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import controller.ControllerLogin;
import entities.Userkey;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Nguyen
 */
public class ActionLogin extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;
    private Userkey user;
    private ControllerLogin controller;
    private List<Userkey> lstUser = new ArrayList<Userkey>();
    private List<Userkey> lstEmail = new ArrayList<Userkey>();

    public ActionLogin() {
        controller = new ControllerLogin();
    }

    public String CheckLogin() {
        String Username = request.getParameter("txt-user");
        String Password = request.getParameter("txt-pass");
        lstUser = controller.checkUser(Username, Password);
        if (lstUser.size() == 1) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
    public String CheckLoginAdmin() {
        String Username = request.getParameter("txt-user-admin");
        String Password = request.getParameter("txt-pass-admin");
        lstUser = controller.checkUserAdmin(Username, Password);
        if (lstUser.size() == 1) {
            return SUCCESS;
        } else {
            return ERROR;          
        }
    }

    public String goHeader() {
        return SUCCESS;
    }

    public String getLogOut() {
        return SUCCESS;
    }

    public String logOut() {
        return SUCCESS;
    }

    public String loginFail() {
        return SUCCESS;
    }

    public String loginIn() {
        return SUCCESS;
    }
    
    public String successAdmin(){
        return SUCCESS;
    }
    public String getLogOutAdmin(){
        return SUCCESS;
    }
    public String logOutAdmin(){
        return SUCCESS;
    }
    public String loginFailAdmin(){
        return SUCCESS;
    }
    public String loginInAdmin(){
        return SUCCESS;
    }
    
    public String goAdminnoNull(){
        return SUCCESS;
    }
    
    public String removeSSRegister(){
        return SUCCESS;
    }
    public String goRegister() {
        return SUCCESS;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public Userkey getUser() {
        return user;
    }

    public void setUser(Userkey user) {
        this.user = user;
    }

    public ControllerLogin getController() {
        return controller;
    }

    public void setController(ControllerLogin controller) {
        this.controller = controller;
    }

    public List<Userkey> getLstUser() {
        return lstUser;
    }

    public void setLstUser(List<Userkey> lstUser) {
        this.lstUser = lstUser;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

}
