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

    public Catalog getCatalog(int id) {
        if (id <= 0) {
            return null;
        }

        Catalog catalog = null;
        try {
            String sql = "from Catalog where catalogId = :id";
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            catalog = (Catalog) query.uniqueResult();
        } catch (Exception e) {
            System.err.println(e);
        }
        return catalog;
    }

    public boolean isDuplicate(String name) {
        String sql = "from Catalog where catalogName = :name";
        Query query = session.createQuery(sql);
        query.setParameter("name", name);
        if (query.list().size() > 0) {
            return true;
        }
        return false;
    }

    public void save(Catalog catalog) {
        session.save(catalog);
    }

    public void update(Catalog catalog) {
        session.update(catalog);
    }

    public void delete(int id) {
        Catalog catalog = (Catalog) session.get(Catalog.class, id);
        session.delete(catalog);
    }
}
