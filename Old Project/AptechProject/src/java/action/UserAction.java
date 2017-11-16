/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import static com.opensymphony.xwork2.Action.ERROR;
import com.opensymphony.xwork2.ActionSupport;
import controller.UserController;
import entities.Userkey;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import util.SendEmail;
import util.SendSMS;

/**
 *
 * @author Linh
 */
public class UserAction extends ActionSupport implements ServletRequestAware {

    private UserController controller;
    List<Userkey> listUser = new ArrayList<>();
    List<Userkey> list = new ArrayList<>();
    private HttpServletRequest request;
    private Userkey user;
    private String birthdate, confirmPass, password;
    private int gender;

    public List<Userkey> getList() {
        return list;
    }

    public void setList(List<Userkey> list) {
        this.list = list;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public UserAction() {
        controller = new UserController();
    }

    public String getAllUser() throws Exception {
        listUser = controller.getAllUser();
        return SUCCESS;
    }

    public String getUserInfo() {
        String ID = request.getParameter("userId");
        int userID = 0;
        try {
            userID = Integer.parseInt(ID);
        } catch (Exception ex) {
        }

        user = controller.getUserById(userID);
        return SUCCESS;
    }

    public String fail() {
        return ERROR;
    }

    public String checkUserName() {
        String name = request.getParameter("user.userName");
        list = controller.isNameExist(name);
        if (list.isEmpty()) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String checkDOB() {
        Date birth = Date.valueOf(this.birthdate);
        Date now = new Date(116, 6, 1);
        Date past = new Date(16, 6, 1);
        if (birth.after(now) || birth.before(past)) {
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    public String checkPassword() {
        if (!this.confirmPass.equals(password) || password.length() < 8) {
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    public String register() {
        Date birth = Date.valueOf(this.birthdate);
        user.setUserDateofbirth(birth);
        if (this.gender == 1) {
            user.setUserGender("Nam");
        } else {
            user.setUserGender("Nữ");
        }
        user.setUserPassword(password);
        listUser = controller.register(this.getUser());
        if (listUser.isEmpty()) {
            return ERROR;
        } else {
            String recipient = listUser.get(0).getUserName();
            String subject = "Dang Ki thành công";
            String message = "Dang ki Thanh Cong";
            //Thong tin SMS
            String phone = listUser.get(0).getUserPhonenum();
            String sms = "Đang ki thanh cong";
            try {
                SendEmail sendemail = new SendEmail();
                SendSMS sendsms = new SendSMS();
                boolean checkSendMail = sendemail.doSendEmail(recipient, subject, message);
                boolean checkSendSMS = sendsms.sendSMSCustomer(phone, sms);
                if (checkSendMail == false || checkSendSMS == false) {
                    return ERROR;
                }
            } catch (Exception e) {
                e.getStackTrace();
                return ERROR;
            }
            return SUCCESS;
        }

    }

    public List<Userkey> getListUser() {
        return listUser;
    }

    public void setListUser(List<Userkey> listUser) {
        this.listUser = listUser;
    }

    public UserController getController() {
        return controller;
    }

    public void setController(UserController controller) {
        this.controller = controller;
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

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

}
