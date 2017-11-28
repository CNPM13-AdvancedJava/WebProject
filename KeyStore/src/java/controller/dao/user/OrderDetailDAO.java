/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao.user;

import java.util.List;
import hibernate.util.HibernateUtil;
import model.dbentities.OrderDetail;
import model.dbentities.OrderDetailId;
import org.hibernate.Session;

/**
 *
 * @author Linh
 */
public class OrderDetailDAO {

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public void addOrderDetail(OrderDetail orderedItem) {
        try {
            session.save(orderedItem);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
