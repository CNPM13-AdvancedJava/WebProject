/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class Pagination {

    private int number;

    public List<Pagination> getListPagging(int size, int n) {
        List<Pagination> ls = new ArrayList<Pagination>();
        int t = 0;
        if (size % n == 0) {
            t = size % n;
        } else {
            t = (int) Math.ceil((double) size / (double) n);
        }

        for (int i = 1; i <= t; i++) {
            Pagination a = new Pagination();
            a.setNumber(i);
            ls.add(a);
        }
        return ls;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }  

}
