/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Linh
 */
public class Page {
    private Integer pageNumber;
    private Boolean isCurrentPage;

    public Page() {
    }

    public Page(Integer pageNumber, Boolean isCurrentPage) {
        this.pageNumber = pageNumber;
        this.isCurrentPage = isCurrentPage;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Boolean getIsCurrentPage() {
        return isCurrentPage;
    }

    public void setIsCurrentPage(Boolean isCurrentPage) {
        this.isCurrentPage = isCurrentPage;
    }
    
    public static List<Page> getPageList(int totalPage, int curPage){
        List<Page> lst = new ArrayList<>();
        for (int i = 1; i <= totalPage; i++){
            Page page = null;
            if (i == curPage){
                page = new Page(i, true);
            }
            else {
                page = new Page(i, false);
            }
            lst.add(page);
        }
        return lst;
    }
}
