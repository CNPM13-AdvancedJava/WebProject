/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import hibernate.util.HibernateTransaction;
import java.util.ArrayList;
import java.util.List;
import model.dbentities.Type;
import org.hibernate.Query;

/**
 *
 * @author Linh
 */
public class TypeDAO  extends HibernateTransaction {
    
    public List<Type> getAllType() {
        List<Type> lstType = new ArrayList<>();
        try {
            Query query = session.createQuery("from Type");
            lstType = query.list();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstType;
    }
    
    public Type getType(int id) {
        Type type = null;
        try {
            Query query = session.createQuery("from Type where typeId = :id");
            query.setParameter("id", id);
            type = (Type) query.uniqueResult();
        } catch (Exception e) {
            System.err.println(e);
        }
        return type;
    }
}
