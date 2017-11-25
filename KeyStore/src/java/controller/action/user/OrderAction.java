/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.user;

import com.opensymphony.xwork2.ActionSupport;
import controller.dao.user.OrderDAO;
import controller.dao.user.OrderDetailDAO;
import controller.dao.user.PaymentMethodDAO;
import controller.dao.user.ProductDAO;
import controller.dao.user.UserDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dbentities.Order;
import model.dbentities.OrderDetail;
import model.dbentities.OrderDetailId;
import model.dbentities.PaymentMethod;
import model.dbentities.ProductDetail;
import model.dbentities.User;
import model.entities.ProductInCart;
import model.entities.UserDetail;
import org.apache.struts2.interceptor.ServletRequestAware;
import util.Util;

/**
 *
 * @author Linh
 */
public class OrderAction extends ActionSupport implements ServletRequestAware {
    HttpServletRequest request;
    ProductDAO productDAO;
    UserDAO userDAO;
    PaymentMethodDAO paymentMethodDAO;
    OrderDAO orderDAO;
    OrderDetailDAO orderDetailDAO;
    
    private String backUrl;
    private List<ProductInCart> lstProductInCart;
    private String totalPrice;
            
    public OrderAction() {
        productDAO = new ProductDAO();
        userDAO = new UserDAO();
        paymentMethodDAO = new PaymentMethodDAO();
        orderDAO = new OrderDAO();
        orderDetailDAO = new OrderDetailDAO();
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
    
    public String getCart(){
        HttpSession session = request.getSession();
        lstProductInCart = (ArrayList) session.getAttribute("cart");
        if (lstProductInCart == null){
            lstProductInCart = new ArrayList<>();
        }
        if (!lstProductInCart.isEmpty()){
            Double total = 0.0;
            productDAO.beginTransaction();
            for (ProductInCart item : lstProductInCart){
                ProductDetail product = productDAO.getProductById(item.getProductId());
                ProductDetail.getThumnailImage(product);
                item.setProductName(product.getProductName());
                item.setProductImage(product.getThumbnailUrl());
                item.setTotalPrice(product.getPrice() * item.getNumber());
                item.setPriceStr(Util.formatPrice(item.getPrice()));
                item.setTotalPriceStr(Util.formatPrice(item.getTotalPrice()));
                total += item.getTotalPrice();
            }
            totalPrice = Util.formatPrice(total);
            productDAO.closeTransaction();
        }
        return SUCCESS;
    }

    public String directPayment(){
        
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        lstProductInCart = (ArrayList) session.getAttribute("cart");
        if (userId == null || lstProductInCart == null || lstProductInCart.isEmpty()){
            return ERROR;
        }
        orderDAO.beginTransaction();
        User user = userDAO.getUserDetailById(userId);
        PaymentMethod method = paymentMethodDAO.getMethodById(1);
        Double totalPayment = ProductInCart.getTotalPayment(lstProductInCart);
        Order order = new Order(method, user, 1, totalPayment, new HashSet());
        Integer orderId = orderDAO.createOrder(order);
        List<OrderDetail> lstOrderedItem = new ArrayList<>();
//        for (ProductInCart item : lstProductInCart){
//            OrderDetailId ODI = new OrderDetailId(orderId, item.getProductId(), item.getNumber());
//            ProductDetail productDetail = productDAO.getProductById(item.getProductId());
//            lstOrderedItem.add(new OrderDetail(ODI, order, productDetail));
//        }
//        orderDetailDAO.addOrderDetail(lstOrderedItem);
        return SUCCESS;
    }
    
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    public String getBackUrl() {
        return backUrl;
    }

    public List<ProductInCart> getLstProductInCart() {
        return lstProductInCart;
    }

    public String getTotalPrice() {
        return totalPrice;
    }
   
}
