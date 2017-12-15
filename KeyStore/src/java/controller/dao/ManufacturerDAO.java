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
import model.dbentities.Manufacturer;
import org.hibernate.Query;

/**
 *
 * @author Bumble Bee
 */
public class ManufacturerDAO extends HibernateTransaction{
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
        if (id < 0) {
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
}
