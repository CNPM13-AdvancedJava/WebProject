/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import model.dbentities.User;
import util.Constant;

/**
 *
 * @author Linh
 */
public class UserInfo {
    
    private User user;
    private String errorMessage = Constant.ErrorMessage.NO_MESSAGE;

    public UserInfo() {
    }

    public UserInfo(User user, String errorMessage) {
        this.user = user;
        this.errorMessage = errorMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    
}
