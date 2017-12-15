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
public class ManufacturerAction extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;
    private HibernateTransaction transaction;
    private ManufacturerDAO manufacturerDAO;

    private List<Manufacturer> manufacturers;
    private String error;
    private int manufacturerId;
    private String manufacturerName;

    public ManufacturerAction() {
        transaction = new HibernateTransaction();
        manufacturerDAO = new ManufacturerDAO();
    }

    public String getAllManufacturer() {
        try {
            transaction.beginTransaction();
            manufacturers = manufacturerDAO.getAllManufacturer();
        } finally {
            transaction.closeTransaction();
        }
        return SUCCESS;
    }

    public String prepareToAdd() {
        return SUCCESS;
    }

    public String addManufacturer() {
        try {
            transaction.beginTransaction();
            String name = request.getParameter("manufacturerName");
            if (name == null || name.isEmpty() || manufacturerDAO.isDuplicate(name)) {
                error = "Tên NSX này không hợp lệ đã tồn tại";
            } else {
                Manufacturer manufacturer = new Manufacturer(name);
                manufacturerDAO.save(manufacturer);
                error = null;
            }
        } finally {
            transaction.closeTransaction();
        }
        if (error == null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String prepareToUpdate() {
        manufacturerId = Integer.parseInt(request.getParameter("manufacturerId"));
        manufacturerName = request.getParameter("manufacturerName");
        return SUCCESS;
    }

    public String updateManufacturer() {
        try {
            int id = Integer.parseInt(request.getParameter("manufacturerId"));
            String name = request.getParameter("manufacturerName");
            transaction.beginTransaction();
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setManufacturerId(id);
            manufacturer.setManufacturerName(name);
            manufacturerDAO.update(manufacturer);
        } finally {
            transaction.closeTransaction();
        }
        return SUCCESS;
    }

    public String deleteManufacturer() {
        try {
            transaction.beginTransaction();
            manufacturerDAO.delete(Integer.parseInt(request.getParameter("manufacturerId")));
        } finally {
            transaction.closeTransaction();
        }
        return SUCCESS;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        request = hsr;
    }

    public String getError() {
        return error;
    }

    public void setManufacturerString(String manufacturerString) {
        this.manufacturerName = manufacturerString;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
}
