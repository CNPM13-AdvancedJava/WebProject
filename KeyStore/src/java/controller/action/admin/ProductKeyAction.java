/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.admin;

import com.opensymphony.xwork2.ActionSupport;
import controller.dao.ProductKeyDAO;
import hibernate.util.HibernateTransaction;
import javax.servlet.http.HttpServletRequest;
import model.dbentities.ProductDetail;
import model.dbentities.ProductKey;
import org.apache.struts2.interceptor.ServletRequestAware;
import util.Constant;

/**
 *
 * @author Linh
 */
public class ProductKeyAction extends ActionSupport implements ServletRequestAware {
    
    private HttpServletRequest request;
    private final HibernateTransaction transaction = new HibernateTransaction();
    private final ProductKeyDAO keyDAO = new ProductKeyDAO();
    
    private ProductDetail product;
    private String MESSAGE;
    
    public String insertProductKey(){
        String result = "invalidKey";
        MESSAGE = Constant.ErrorMessage.ADD_KEY_FAILED;
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String productKey = request.getParameter("productKey");
        try {
            transaction.beginTransaction();
            product = new ProductDetail();
            product.setProductId(Integer.parseInt(productId));
            product.setProductName(productName);
            ProductKey key = new ProductKey(productKey);
            boolean isKeyExist = keyDAO.isKeyExist(productKey);
            if (!isKeyExist){
                key.setProductDetail(product);
                key.setStatus(1);
                keyDAO.addKey(key);
                result = SUCCESS;
                MESSAGE = Constant.SuccessMessage.ADD_KEY_SUCCESS;
            }
        }
        catch (Exception e){
            transaction.rollback();
            System.err.println(e);
        }
        finally {
            transaction.closeTransaction();
        }
        return result;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        request = hsr;
    }

    public ProductDetail getProduct() {
        return product;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }
    
}
