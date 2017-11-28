/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao.user;

import hibernate.util.HibernateUtil;
import model.dbentities.Order;
import org.hibernate.Session;

/**
 *
 * @author Linh
 */
public class OrderDAO {

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public void beginTransaction() {
        session.beginTransaction();
    }

    public void closeTransaction() {
        session.getTransaction().commit();
    }

    public Integer createOrder(Order order) {
        try {
            session.save(order);
        } catch (Exception e) {
            System.err.println(e);
        }
        return order.getOrderId();
    }

}
