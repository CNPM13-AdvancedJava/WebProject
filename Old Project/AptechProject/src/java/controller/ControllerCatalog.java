package controller;

import java.util.List;
import model.HibernateUtil;
import org.hibernate.Session;
import entities.Gametype;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

public class ControllerCatalog {

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public List<Gametype> getMenu() {
        List<Gametype> lstMenu = new ArrayList<Gametype>();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Gametype Where catalog_id = 0");
            lstMenu = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstMenu;
    }

    public List<Gametype> getGamtype(int size) {

        List<Gametype> lst = new ArrayList<Gametype>();
        try {
            Query query = session.createQuery("from Gametype Where catalog_id = :catalogid");
            query.setParameter("catalogid", size);
            lst = query.list();    
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }       
        return lst;
    }
}
