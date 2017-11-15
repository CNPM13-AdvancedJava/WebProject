/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.dbentities.User;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Linh
 */
public class Util {
    public static int getTotalPage(int itemNumer, int pageSize){
        if ((itemNumer % pageSize) == 0){
            return itemNumer / pageSize;
        }
        else {
            return (itemNumer / pageSize) + 1;
        }
    }
    
    public static List getPagitation(List lst, int page, int pageSize){
        if (lst == null) 
            return new LinkedList();
        
        int maxSize = lst.size();
        int startIndex = (page-1) * pageSize;
        int endIndex = (page * pageSize);
        
        if (maxSize <= startIndex){
            return lst;
        }
        else if (maxSize <= endIndex) {
            lst = lst.subList(startIndex, maxSize);
        }
        else {
            lst = lst.subList(startIndex, endIndex);
        }
        return lst;
    }
    
    public static String validatePassword(String pwd, String cfmPw){
        String errorMessage = Constant.ErrorMessage.NO_MESSAGE;
        if (!pwd.equals(cfmPw)){
            errorMessage = Constant.ErrorMessage.PWD_AND_CFMPWD_NOT_MATCH;
        }
        if (pwd.length() < 8 || pwd.length() > 20){
            errorMessage = Constant.ErrorMessage.INVALID_PASSWORD_LENGTH;
        }
        return errorMessage;
    }
    
    public static String validateUser(User user){
        String errorMessage = Constant.ErrorMessage.NO_MESSAGE;
        if (user.getGender() > 1 || user.getGender() < 0){
            errorMessage = Constant.ErrorMessage.INVALID_GENDER;
        }
        if (user.getEmail().length() > 50){
            errorMessage = Constant.ErrorMessage.INVALID_USER_NAME_LENGTH;
        }
        if (user.getUserName().length() > 50){
            errorMessage = Constant.ErrorMessage.INVALID_USER_NAME_LENGTH;
        }
        Calendar now = Calendar.getInstance();
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.setTime(user.getDateOfBirth());
        dateOfBirth.add(Calendar.YEAR, 16);
        if (now.before(dateOfBirth)){
            errorMessage = Constant.ErrorMessage.INVALID_DATE_OF_BIRTH;
        }
        if (user.getPhoneNumber().length() > 14){
            errorMessage = Constant.ErrorMessage.INVALID_PHONE_NUMBER_LENGTH;
        }
        if (user.getAddress().length() > 100){
            errorMessage = Constant.ErrorMessage.INVALID_ADDRESS_LENGTH;
        }
        return errorMessage;
    }
}
