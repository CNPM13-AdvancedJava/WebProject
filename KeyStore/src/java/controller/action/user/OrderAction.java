/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.user;

import com.opensymphony.xwork2.ActionSupport;
import controller.dao.user.ProductDAO;
import controller.dao.user.UserDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dbentities.ProductDetail;
import model.entities.ProductInCart;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Linh
 */
public class OrderAction extends ActionSupport implements ServletRequestAware {
    HttpServletRequest request;
    ProductDAO productDAO;
    UserDAO userDAO;
    
    private String backUrl;
            
    public OrderAction() {
        productDAO = new ProductDAO();
        userDAO = new UserDAO();
    }
    
    public String addToCart(){
        String userId = (String) request.getParameter("userId");
        Integer productId = Integer.parseInt((String) request.getParameter("productId"));
        Integer number = Integer.parseInt((String) request.getParameter("number"));
        
        HttpSession session = request.getSession();
        ArrayList<ProductInCart> cart = (ArrayList) session.getAttribute("cart");
        if (cart == null){
            cart = new ArrayList<>();
        }
        productDAO.beginTransaction();
        ProductDetail product = productDAO.getProductById(productId);
        productDAO.closeTransaction();
        boolean isAdd = false;
        for (ProductInCart item : cart){
            if (item.getProductId().equals(product.getProductId())){
                item.setNumber(item.getNumber() + 1);
                isAdd = true;
                break;
            }
        }
        if (!isAdd)
            cart.add(new ProductInCart(product.getProductId(), product.getPrice(), number));
        session.setAttribute("cart", cart);
        session.setAttribute("amount", cart.size());
        
        backUrl = request.getHeader("referer");
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    public String getBackUrl() {
        return backUrl;
    }
   
}
