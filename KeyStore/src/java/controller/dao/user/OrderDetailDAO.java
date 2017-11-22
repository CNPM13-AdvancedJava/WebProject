/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao.user;

import java.util.List;
import model.HibernateUtil;
import model.dbentities.OrderDetail;
import model.dbentities.OrderDetailId;
import org.hibernate.Session;

/**
 *
 * @author Linh
 */
public class OrderDetailDAO {

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public void addOrderDetail(List<OrderDetail> lstOrderedItem) {
        for (OrderDetail item : lstOrderedItem) {
            try {
                session.save(item);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}
