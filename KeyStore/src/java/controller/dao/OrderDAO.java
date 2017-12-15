/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import hibernate.util.HibernateTransaction;
import java.util.ArrayList;
import java.util.List;
import model.dbentities.Order;
import org.hibernate.Query;

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

    public List<Order> getAllOrder() {
        List<Order> lstOrder = new ArrayList<>();
        try {
            Query query = session.createQuery("from Order order by orderTime desc");
            lstOrder = query.list();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstOrder;
    }

}
