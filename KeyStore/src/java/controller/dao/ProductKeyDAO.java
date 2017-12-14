/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import hibernate.util.HibernateTransaction;
import java.util.ArrayList;
import java.util.List;
import model.dbentities.ProductKey;
import org.hibernate.Query;

/**
 *
 * @author Linh
 */
public class ProductKeyDAO extends HibernateTransaction {
    
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

    public void addKey(ProductKey key) {
        session.save(key);
    }

    public boolean isKeyExist(String productKey) {
        try {
            String sql = "from ProductKey where keyId = :keyId";
            Query query = session.createQuery(sql);
            query.setParameter("keyId", productKey);
            List lstKey = query.list();
            if (lstKey != null && !lstKey.isEmpty()){
                return true;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }
}
