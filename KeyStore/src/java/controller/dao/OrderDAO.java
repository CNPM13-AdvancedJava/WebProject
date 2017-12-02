/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import hibernate.util.HibernateTransaction;
import model.dbentities.Order;

/**
 *
 * @author Linh
 */
public class OrderDAO extends HibernateTransaction {

    public Integer createOrder(Order order) {
        try {
            session.save(order);
        } catch (Exception e) {
            System.err.println(e);
        }
        return order.getOrderId();
    }

}
