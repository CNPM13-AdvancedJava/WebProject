package controller;

import entities.Product;
import java.util.ArrayList;
import java.util.List;
import model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class ControllerSearch {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    public List<Product> SearchProduct(String searchValue){
        List<Product> lstProduct = new ArrayList<Product>();
        try {
            session.beginTransaction();
            Query query = session.createQuery("From Product Where product_name like :searchValue");
            searchValue = "%"+searchValue+"%";
            query.setParameter("searchValue", searchValue);
            lstProduct = query.list();
        } catch (Exception e) {
        }
        return lstProduct;
    }
    public List<Product> lstSearchProduct(String searchValue,int first,int max){
        List<Product> lstProduct = new ArrayList<Product>();
        try {
            Query query = session.createQuery("From Product Where product_name like :searchValue");
            searchValue = "%"+searchValue+"%";
            query.setParameter("searchValue", searchValue);
            query.setFirstResult(first);
            query.setMaxResults(max);
            lstProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lstProduct;
    }
    public List<Product> SearchProductbyGametype(int gameId){
        List<Product> lstProduct = new ArrayList<Product>();
        try {
            session.beginTransaction();
            Query query = session.createQuery("From Product Where gametype_id = :gameId");
            query.setParameter("gameId", gameId);
            lstProduct = query.list();
        } catch (Exception e) {
        }
        return lstProduct;
    }
    public List<Product> lstSearchProductbyGametype(int gameId,int first,int max){
        List<Product> lstProduct = new ArrayList<Product>();
        try {
            Query query = session.createQuery("From Product Where gametype_id = :gameId");
            query.setParameter("gameId", gameId);
            query.setFirstResult(first);
            query.setMaxResults(max);
            lstProduct = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lstProduct;
    }
}
