/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import controller.ControllerUser;
import entities.Userkey;
import java.io.File;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Nguyen
 */
public class ActionUser extends ActionSupport implements ServletRequestAware {

    private Userkey user;
    private Userkey userCheck;
    private Userkey userById;
    private HttpServletRequest request;
    private ControllerUser controller;
    private List<Userkey> lstUser = new ArrayList<Userkey>();
    private String userImagesFile;
    private File userImage;
    private String birtdate;
    private int gender;

    public ActionUser() {
        controller = new ControllerUser();
    }

    public String getAllUser() {
        String userName = request.getParameter("userNameList");
        lstUser = controller.getAllUser(userName);
        int userId = lstUser.get(0).getUserId();
        user = controller.getUserbyId(userId);
        return SUCCESS;
    }

    public String getUserbyId() {
        String suserId = request.getParameter("userChangeId");
        int userId = 0;
        try {
            userId = Integer.parseInt(suserId);
        } catch (Exception e) {
            e.getStackTrace();
        }
        userById = controller.getUserbyIdinChange(userId);
        Date cvdate = userById.getUserDateofbirth();
        birtdate = cvdate.toString();
        return SUCCESS;
    }

    public String updatebyIdUser() {
        String suserId = request.getParameter("userUpdateId");
        String gioitinh = "";
        if (this.gender == 1);
        {
            gioitinh = "Nam";
        }
        if (this.gender == 2) {
            gioitinh = "Nữ";
        }
        String phone = request.getParameter("txt-phone");
        String address = request.getParameter("txt-address");
        int userId = 0;
        try {
            userId = Integer.parseInt(suserId);
        } catch (Exception e) {
            e.getStackTrace();
        }
        Date birth = Date.valueOf(birtdate);
        userCheck = controller.checkNullUser(userId);
        String checkNull = userCheck.getUserName();
        if (checkNull != null) {
//            String filePath = "D:\\Aptect\\Project\\AptechProject\\web\\images\\user";
//            String fname = "";
//            String realName = "";
//            String linkanh = "images/user/";
//            try {
//                int x = userImagesFile.lastIndexOf(".");
//                String tail = userImagesFile.substring(x);
//                fname = createName() + tail;
//                File fileToCreate = new File(filePath, fname);
//                FileUtils.copyFile(userImage, fileToCreate);
//                realName = linkanh + "/" + fname;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }           
            user = controller.updateUser(phone, gioitinh, address, birth, userId);            
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
    
    public String getUseroldUpdate(){
        String userName = (String) request.getAttribute("userName");
        lstUser = controller.getUseroldUpdate(userName);
        int userId = lstUser.get(0).getUserId();
        userById = controller.getUserbyIdoldUpdate(userId);
        return SUCCESS;
    }

    public String changePassword() {
        String usId = request.getParameter("userChangepassId");
        int userId = 0;
        try {
            userId = Integer.parseInt(usId);
        } catch (Exception e) {
            e.getStackTrace();
        }
        String oldPass = request.getParameter("oldpass");
        String newPass = request.getParameter("newpass");
        String renewPass = request.getParameter("renewpass");
        lstUser = controller.getPassChange(oldPass, userId);
        if (lstUser.size() != 0 && newPass.equals(renewPass)) {
            user = controller.changePass(newPass, userId);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    private String createName() {
        String name = "";
        Date now = new Date(116, 6, 1);
        name += now.getYear() + "" + now.getMonth() + "" + now.getDay() + "" + now.getHours() + "" + now.getMinutes() + "" + now.getSeconds();
        return name;
    }

    public Userkey getUser() {
        return user;
    }

    public void setUser(Userkey user) {
        this.user = user;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public ControllerUser getController() {
        return controller;
    }

    public void setController(ControllerUser controller) {
        this.controller = controller;
    }

    public List<Userkey> getLstUser() {
        return lstUser;
    }

    public void setLstUser(List<Userkey> lstUser) {
        this.lstUser = lstUser;
    }

    public Userkey getUserById() {
        return userById;
    }

    public void setUserById(Userkey userById) {
        this.userById = userById;
    }

    public String getUserImagesFile() {
        return userImagesFile;
    }

    public void setUserImagesFile(String userImagesFile) {
        this.userImagesFile = userImagesFile;
    }

    public File getUserImage() {
        return userImage;
    }

    public void setUserImage(File userImage) {
        this.userImage = userImage;
    }

    public String getBirtdate() {
        return birtdate;
    }

    public void setBirtdate(String birtdate) {
        this.birtdate = birtdate;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }   

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

}
