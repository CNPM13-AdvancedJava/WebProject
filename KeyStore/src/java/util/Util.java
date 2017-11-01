/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

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
        int endIndex = (page * pageSize) - 1;
        
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
}
