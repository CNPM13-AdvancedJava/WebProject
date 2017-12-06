/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.util;

import org.hibernate.Session;

/**
 *
 * @author Linh
 */
public class HibernateTransaction {
    
    protected Session session = HibernateFactory.getSessionFactory().getCurrentSession();
    
    public void beginTransaction(){
        session.beginTransaction();
    }
    
    public void closeTransaction(){
        session.getTransaction().commit();
    }
    
    public void rollback(){
        session.getTransaction().rollback();
    }
}
