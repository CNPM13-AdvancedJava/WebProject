/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import hibernate.util.HibernateTransaction;
import model.dbentities.OrderDetail;

/**
 *
 * @author Linh
 */
public class OrderDetailDAO extends HibernateTransaction {

    public void addOrderDetail(OrderDetail orderedItem) {
        try {
            session.save(orderedItem);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
