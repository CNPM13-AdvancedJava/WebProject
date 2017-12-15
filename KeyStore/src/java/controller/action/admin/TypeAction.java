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
import controller.dao.TypeDAO;
import hibernate.util.HibernateTransaction;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.dbentities.Catalog;
import model.dbentities.Type;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Bumble Bee
 */
public class TypeAction extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;
    private HibernateTransaction transaction;
    private TypeDAO typeDAO;

    private List<Type> types;
    private String error;
    private int typeId;
    private String typeName;

    public TypeAction() {
        transaction = new HibernateTransaction();
        typeDAO = new TypeDAO();
    }

    public String getAllType() {
        try {
            transaction.beginTransaction();
            types = typeDAO.getAllType();
        } finally {
            transaction.closeTransaction();
        }
        return SUCCESS;
    }

    public String prepareToAdd() {
        return SUCCESS;
    }

    public String addType() {
        try {
            transaction.beginTransaction();
            String name = request.getParameter("typeName");
            if (name == null || name.isEmpty() || typeDAO.isDuplicate(name)) {
                error = "Tên thể loại này không hợp lệ đã tồn tại";
            } else {
                Type type = new Type();
                type.setTypeName(name);
                typeDAO.save(type);
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
        typeId = Integer.parseInt(request.getParameter("typeId"));
        typeName = request.getParameter("typeName");
        return SUCCESS;
    }

    public String prepareToUpdateAgain() {
        typeId = Integer.parseInt(request.getParameter("typeId"));
        typeName = request.getParameter("typeName");
        error = "Tên thể loại này không hợp lệ đã tồn tại";
        return SUCCESS;
    }

    public String updateType() {
        try {
            transaction.beginTransaction();
            int id = Integer.parseInt(request.getParameter("typeId"));
            String oldName = typeDAO.getType(id).getTypeName();
            String name = request.getParameter("typeName");

            if (oldName != null && oldName.equals(name)) {
                error = null;
            } else if (name == null || name.isEmpty() || typeDAO.isDuplicate(name)) {
                error = "Tên thể loại này không hợp lệ đã tồn tại";
                typeId = id;
                typeName = oldName;
            } else {
                Type type = typeDAO.getType(id);
                type.setTypeName(name);
                typeDAO.update(type);
                error = null;
            }
        } finally {
            transaction.closeTransaction();
        }
        return error == null ? SUCCESS : ERROR;
    }

    public String deleteType() {
        try {
            transaction.beginTransaction();
            typeDAO.delete(Integer.parseInt(request.getParameter("typeId")));
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

    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public List<Type> getTypes() {
        return types;
    }
}
