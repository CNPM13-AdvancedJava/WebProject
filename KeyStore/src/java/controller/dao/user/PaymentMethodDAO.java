/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao.user;

import model.HibernateUtil;
import model.dbentities.PaymentMethod;
import org.hibernate.Session;

/**
 *
 * @author Linh
 */
public class PaymentMethodDAO {
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    public PaymentMethod getMethodById(int id) {
        PaymentMethod method = null;
        try {
            method = (PaymentMethod) session.get(PaymentMethod.class, id);
        } catch (Exception e) {
            System.err.println(e);
        }
        return method;
    }
}
