/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.admin;

import com.opensymphony.xwork2.ActionSupport;
import controller.dao.CatalogDAO;
import controller.dao.ManufacturerDAO;
import controller.dao.ProductDAO;
import controller.dao.TypeDAO;
import hibernate.util.HibernateTransaction;
import java.util.ArrayList;
import java.util.List;
import javax.resource.spi.work.HintsContext;
import javax.servlet.http.HttpServletRequest;
import model.dbentities.Catalog;
import model.dbentities.Manufacturer;
import model.dbentities.ProductDetail;
import model.dbentities.Type;
import model.entities.Product;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Bumble Bee
 */
public class ManufacturerAction extends ActionSupport implements ServletRequestAware{
    private HttpServletRequest request;
    private HibernateTransaction transaction;
    private ManufacturerDAO manufacturerDAO;
    
    public List<Manufacturer> manufacturers;

    public ManufacturerAction() {
        transaction = new HibernateTransaction();
        manufacturerDAO = new ManufacturerDAO();
    }
    
    public String getAllManufacturer(){
        try {
            transaction.beginTransaction();
            manufacturers = manufacturerDAO.getAllManufacturer();
        } finally {
            transaction.closeTransaction();
        }
        return SUCCESS;
    }
    
    public List<Manufacturer> getMManufacturers() {
        return manufacturers;
    }
        
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        request = hsr;
    }
    
}
