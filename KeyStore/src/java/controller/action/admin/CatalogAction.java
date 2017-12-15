/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.admin;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import controller.dao.CatalogDAO;
import hibernate.util.HibernateTransaction;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.dbentities.Catalog;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Bumble Bee
 */
public class CatalogAction extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;
    private HibernateTransaction transaction;
    private CatalogDAO catalogDAO;

    private List<Catalog> catalogs;
    private String error;
    private int catalogId;
    private String catalogName;

    public CatalogAction() {
        transaction = new HibernateTransaction();
        catalogDAO = new CatalogDAO();
    }

    public String getAllCatalog() {
        try {
            transaction.beginTransaction();
            catalogs = catalogDAO.getAllCatalog();
        } finally {
            transaction.closeTransaction();
        }
        return SUCCESS;
    }

    public String prepareToAdd() {
        return SUCCESS;
    }

    public String addCatalog() {
        try {
            transaction.beginTransaction();
            String name = request.getParameter("catalogName");
            if (name == null || name.isEmpty() || catalogDAO.isDuplicate(name)) {
                error = "Tên Catalog này không hợp lệ đã tồn tại";
            } else {
                Catalog catalog = new Catalog();
                catalog.setCatalogName(name);
                catalogDAO.save(catalog);
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
        catalogId = Integer.parseInt(request.getParameter("catalogId"));
        catalogName = request.getParameter("catalogName");
        return SUCCESS;
    }

    public String prepareToUpdateAgain() {
        catalogId = Integer.parseInt(request.getParameter("manufacturerId"));
        catalogName = request.getParameter("manufacturerName");
        error = "Tên NSX này không hợp lệ đã tồn tại";
        return SUCCESS;
    }

    public String updateCatalog() {
        try {
            transaction.beginTransaction();
            int id = Integer.parseInt(request.getParameter("catalogId"));
            String oldName = catalogDAO.getCatalog(id).getCatalogName();
            String name = request.getParameter("catalogName");

            if (oldName != null && oldName.equals(name)) {
                error = null;
            } else if (name == null || name.isEmpty() || catalogDAO.isDuplicate(name)) {
                error = "Tên NSX này không hợp lệ đã tồn tại";
                catalogId = id;
                catalogName = oldName;
            } else {
                Catalog catalog = catalogDAO.getCatalog(id);
                catalog.setCatalogName(name);
                catalogDAO.update(catalog);
                error = null;
            }
        } finally {
            transaction.closeTransaction();
        }
        return error == null ? SUCCESS : ERROR;
    }

    public String deleteCatalog() {
        try {
            transaction.beginTransaction();
            catalogDAO.delete(Integer.parseInt(request.getParameter("catalogId")));
        } finally {
            transaction.closeTransaction();
        }
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        request = hsr;
    }

    public String getError() {
        return error;
    }

    public List<Catalog> getCatalogs() {
        return catalogs;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }
}
