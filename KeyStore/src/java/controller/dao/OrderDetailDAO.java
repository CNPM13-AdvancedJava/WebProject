/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import hibernate.util.HibernateTransaction;
import java.util.ArrayList;
import java.util.List;
import model.dbentities.OrderDetail;
import org.hibernate.Query;

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

    public List<OrderDetail> getDetailByOrderId(Integer orderId) {
        List<OrderDetail> lstDetail = new ArrayList<>();
        try {
            Query query = session.createQuery("from OrderDetail where id.orderId = :id");
            query.setParameter("id", orderId);
            lstDetail = query.list();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstDetail;
    }
}
