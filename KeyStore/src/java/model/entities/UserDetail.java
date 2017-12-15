/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.dbentities.User;
import utils.Util;

/**
 *
 * @author Linh
 */
public class UserDetail {
    private String userId;
    private String userName;
    private String email;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String address;
    private String money;
    
    public UserDetail(User user){
        this.userId = user.getUserId().toString();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        if (user.getGender() == 1){
            gender = "Nam";
        }
        else {
            gender = "Nữ";
        }
        this.dateOfBirth = user.getDateOfBirth().toString();
        this.phoneNumber = user.getPhoneNumber();
        this.address = user.getAddress();
        this.money = Util.formatPrice(user.getMoney());
    }

    public UserDetail(String userId, String email, String userName, String dateOfBirth, String phoneNumber, String address) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    
}
