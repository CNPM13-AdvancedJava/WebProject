/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import hibernate.util.HibernateTransaction;
import model.dbentities.PaymentMethod;

/**
 *
 * @author Linh
 */
public class PaymentMethodDAO extends HibernateTransaction {
    
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
