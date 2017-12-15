/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import model.dbentities.Admin;
import utils.Constant;

/**
 *
 * @author Linh
 */
public class AdminInfo {
    
    private Admin admin;
    private String errorMessage = Constant.ErrorMessage.NO_MESSAGE;
    private String successMessage = Constant.ErrorMessage.NO_MESSAGE;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
    
}
