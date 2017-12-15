/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.admin;

import com.opensymphony.xwork2.ActionSupport;
import controller.dao.OrderDAO;
import controller.dao.OrderDetailDAO;
import controller.dao.UserDAO;
import hibernate.util.HibernateTransaction;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.dbentities.Order;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Linh
 */
public class OrderAction extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;
    private final HibernateTransaction transaction = new HibernateTransaction();
    private final OrderDAO orderDAO = new OrderDAO();
    private final OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    private final UserDAO userDAO = new UserDAO();
    
    private List<Order> lstOrder;
    
    public String getAllOrder(){
        try {
            transaction.beginTransaction();
            lstOrder = orderDAO.getAllOrder();
            for (Order order : lstOrder){
                if (order.getStatus() == 1) {
                    order.setStt("Đã chuyển hàng");
                } else {
                    order.setStt("Chưa chuyển hàng");
                }
                order.setAmount(order.getOrderDetails().size());
            }
        }
        catch (Exception e){
            System.err.println(e);
            transaction.rollback();
        }
        finally {
            transaction.closeTransaction();
        }
        return SUCCESS;
    }
    
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        request = hsr;
    }

    public List<Order> getLstOrder() {
        return lstOrder;
    }
    
}
