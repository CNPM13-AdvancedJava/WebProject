/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import hibernate.util.HibernateTransaction;
import model.dbentities.ProductImage;

/**
 *
 * @author Bumble Bee
 */
public class ProductImageDAO extends HibernateTransaction {

    public void saveOrUpdateImage(ProductImage image) {
        session.saveOrUpdate(image);
    }
    
    public void deleteImage(ProductImage img) {
        session.delete(img);
    }
    
}
