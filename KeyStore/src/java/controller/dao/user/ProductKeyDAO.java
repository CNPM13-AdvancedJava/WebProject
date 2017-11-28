/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao.user;

import java.util.ArrayList;
import java.util.List;
import hibernate.util.HibernateUtil;
import model.dbentities.ProductKey;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Linh
 */
public class ProductKeyDAO {

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public List<ProductKey> getAvailableKey(int productId, int amount) {
        List lstKey = new ArrayList();
        try {
            String sql = "from ProductKey where productDetail.productId = :productId and status = 1";
            Query query = session.createQuery(sql).setMaxResults(amount);
            query.setParameter("productId", productId);
            lstKey = query.list();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lstKey;
    }
}
