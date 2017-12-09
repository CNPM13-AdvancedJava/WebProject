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
import org.hibernate.Query;

/**
 *
 * @author Linh
 */
public class CatalogDAO extends HibernateTransaction {
    
    public List<Catalog> get5Catalog() {
        List<Catalog> lstCatalog = new ArrayList<>();
        try {
            Query query = session.createQuery("from Catalog").setMaxResults(5);
            lstCatalog = query.list();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstCatalog;
    }
    
    public List<Catalog> getAllCatalog() {
        List<Catalog> lstCatalog = new ArrayList<>();
        try {
            Query query = session.createQuery("from Catalog");
            lstCatalog = query.list();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstCatalog;
    }
}
