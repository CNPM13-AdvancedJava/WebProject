/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import hibernate.util.HibernateTransaction;
import java.util.ArrayList;
import java.util.List;
import model.dbentities.Catalog;
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
        if (id <= 0) {
            return null;
        }
        Query query = session.createQuery("from Type where typeId = :id");
        query.setParameter("id", id);
        return (Type) query.uniqueResult();
    }
    
    public boolean isDuplicate(String name) {
        String sql = "from Type where typeName = :name";
        Query query = session.createQuery(sql);
        query.setParameter("name", name);
        if (query.list().size() > 0) {
            return true;
        }
        return false;
    }

    public void save(Type type) {
        session.save(type);
    }

    public void update(Type type) {
        session.update(type);
    }

    public void delete(int id) {
        Type type = (Type) session.get(Type.class, id);
        session.delete(type);
    }
}
