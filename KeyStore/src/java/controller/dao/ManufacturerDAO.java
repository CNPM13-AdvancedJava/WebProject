/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import hibernate.util.HibernateTransaction;
import java.util.ArrayList;
import java.util.List;
import model.dbentities.Manufacturer;
import org.hibernate.Query;

/**
 *
 * @author Bumble Bee
 */
public class ManufacturerDAO extends HibernateTransaction {

    public List<Manufacturer> getAllManufacturer() {
        List<Manufacturer> manufacturers = new ArrayList<>();
        try {
            Query query = session.createQuery("from Manufacturer");
            manufacturers = query.list();
        } catch (Exception e) {
            System.err.println(e);
        }
        return manufacturers;
    }

    public Manufacturer getManufacturer(int id) {
        if (id <= 0) {
            return null;
        }

        Manufacturer manufacturer = null;
        try {
            String sql = "from Manufacturer where manufacturerId = :id";
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            manufacturer = (Manufacturer) query.uniqueResult();
        } catch (Exception e) {
            System.err.println(e);
        }
        return manufacturer;
    }

    public boolean isDuplicate(String name) {
        String sql = "from Manufacturer where manufacturerName = :name";
        Query query = session.createQuery(sql);
        query.setParameter("name", name);
        if (query.list().size() > 0) {
            return true;
        }
        return false;
    }

    public void save(Manufacturer manufacturer) {
        session.save(manufacturer);
    }
    
    public void update(Manufacturer manufacturer) {
        session.update(manufacturer);
    }

    public void delete(int id) {
        Manufacturer manufacturer = (Manufacturer) session.get(Manufacturer.class, id);
        session.delete(manufacturer);
    }
}
