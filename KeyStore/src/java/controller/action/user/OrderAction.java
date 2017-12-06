/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.user;

import com.opensymphony.xwork2.ActionSupport;
import controller.dao.OrderDAO;
import controller.dao.OrderDetailDAO;
import controller.dao.PaymentMethodDAO;
import controller.dao.ProductDAO;
import controller.dao.ProductKeyDAO;
import controller.dao.UserDAO;
import hibernate.util.HibernateTransaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dbentities.Order;
import model.dbentities.OrderDetail;
import model.dbentities.OrderDetailId;
import model.dbentities.PaymentMethod;
import model.dbentities.ProductDetail;
import model.dbentities.ProductKey;
import model.dbentities.User;
import model.entities.ProductInCart;
import org.apache.struts2.interceptor.ServletRequestAware;
import util.EmailSender;
import util.Util;

/**
 *
 * @author Linh
 */
public class OrderAction extends ActionSupport implements ServletRequestAware {
    HttpServletRequest request;
    
    HibernateTransaction transaction;
    ProductDAO productDAO;
    ProductKeyDAO productKeyDAO;
    UserDAO userDAO;
    PaymentMethodDAO paymentMethodDAO;
    OrderDAO orderDAO;
    OrderDetailDAO orderDetailDAO;
    
    private String backUrl;
    private List<ProductInCart> lstProductInCart;
    private String totalPrice;
            
    public OrderAction() {
        transaction = new HibernateTransaction();
        productDAO = new ProductDAO();
        productKeyDAO = new ProductKeyDAO();
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
        transaction.beginTransaction();
        ProductDetail product = productDAO.getProductById(productId);
        transaction.closeTransaction();
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
    
    public String removeFromCart(){
        Integer productId = Integer.parseInt((String) request.getParameter("productId"));
        HttpSession session = request.getSession();
        ArrayList<ProductInCart> cart = (ArrayList) session.getAttribute("cart");
        if (cart == null){
            cart = new ArrayList<>();
        }
        for (ProductInCart item : cart){
            if (item.getProductId().equals(productId)){
                cart.remove(item);
                break;
            }
        }
        
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
            transaction.beginTransaction();
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
            transaction.closeTransaction();
        }
        return SUCCESS;
    }

    public String directPayment(){
        
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        lstProductInCart = (ArrayList) session.getAttribute("cart");
        if (userId == null || lstProductInCart == null || lstProductInCart.isEmpty()){
            return "login";
        }
        transaction.beginTransaction();
        User user = userDAO.getUserDetailById(userId);
        PaymentMethod method = paymentMethodDAO.getMethodById(1);
        Double totalPayment = ProductInCart.getTotalPayment(lstProductInCart);
        if (totalPayment > user.getMoney()){
            transaction.closeTransaction();
            return ERROR;
        }
        user.setMoney(user.getMoney() - totalPayment);
        userDAO.update(user);
//        Map<String, ProductDetail> keyMap = new HashMap<>();
        Order order = new Order(method, user, 0, totalPayment, new Date(), new HashSet());
        Integer orderId = orderDAO.createOrder(order);
//        List<OrderDetail> lstOrderedItem = new ArrayList<>();
        for (ProductInCart item : lstProductInCart){
//            ProductDetail productDetail = productDAO.getProductById(item.getProductId());
            List<ProductKey> lstKey = productKeyDAO.getAvailableKey(item.getProductId(), item.getNumber());
            for (ProductKey key : lstKey){
                OrderDetailId ODI = new OrderDetailId(orderId, key.getKeyId());
                OrderDetail OD = new OrderDetail(ODI, order, key, 1);
                orderDetailDAO.addOrderDetail(OD);
//                keyMap.put(key.getKeyId(), productDetail);
            }
        }
        transaction.closeTransaction();
        session.removeAttribute("cart");
        session.removeAttribute("amount");
        
//        EmailSender.sendProductKey(user, keyMap);
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
