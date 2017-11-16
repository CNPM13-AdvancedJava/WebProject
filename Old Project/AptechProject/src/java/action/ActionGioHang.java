/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import controller.ControllerGioHang;
import entities.Allorder;
import entities.Method;
import entities.Product;
import entities.Userkey;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

public class ActionGioHang extends ActionSupport implements ServletRequestAware {

    private Product product;
    private Product productbyId;
    private Userkey userkey;
    private Method method;
    private Allorder allorder;
    private HttpServletRequest request;
    private ControllerGioHang controller;
    private List<Userkey> lstUser = new ArrayList<Userkey>();
    private List<Product> lstProduct = new ArrayList<Product>();
    private List<Allorder> lstOrder = new ArrayList<Allorder>();
    private List<Product> listProductref = new ArrayList<Product>();
    private int tongsotien;

    public ActionGioHang() {
        controller = new ControllerGioHang();
    }

    public String addCart() {
        String ProId = request.getParameter("productId");
        String userNameDH = request.getParameter("userNameDH");
        String number = request.getParameter("number-pay");
        int ProSearchId = 0;
        int numberAdd = 0;
        int methodId = 1;
        try {
            ProSearchId = Integer.parseInt(ProId);
            numberAdd = Integer.parseInt(number);
        } catch (Exception e) {
            e.printStackTrace();
        }
        lstUser = controller.checkEmail(userNameDH);
        int userId = lstUser.get(0).getUserId();
        Allorder addcart = new Allorder();
        product = new Product();
        product.setProductId(ProSearchId);
        userkey = new Userkey();
        userkey.setUserId(userId);
        method = new Method();
        method = controller.getMethodById(methodId);
        int kq = 0;
        int price = controller.getProductById(ProSearchId).getPrince();
        try {
            kq = numberAdd * price;
        } catch (Exception e) {
            e.printStackTrace();
        }
        String orderstt = "unpaid";
        addcart.setNumber(numberAdd);
        addcart.setFinistnum(kq);
        addcart.setMethod(method);
        addcart.setProduct(product);
        addcart.setUserkey(userkey);
        addcart.setOrderPstatus(orderstt);
        controller.addOrder(addcart);
        productbyId = (Product) controller.getProById(ProSearchId);
        int gameType = productbyId.getGametype().getGametypeId();
        listProductref = controller.getProductRef(gameType,ProSearchId);
        return SUCCESS;
    }

    public String getOrderbyName() {
        String userName = request.getParameter("userNameGH");
        lstUser = controller.checkEmailbyGH(userName);
        int searchId = lstUser.get(0).getUserId();
        String sttsearch = "unpaid";
        lstOrder = controller.getListOrder(searchId,sttsearch);
        for (int i = 0; i < lstOrder.size(); i++) {
            tongsotien += lstOrder.get(i).getFinistnum();
        }
        lstProduct = controller.getAllProduct();
        return SUCCESS;
    }

    public String deleteOrder() {
        String Id = request.getParameter("orderId");
        String userNameId = request.getParameter("userNameId");
        int orderId = 0;
        int userId = 0;
        try {
            userId = Integer.parseInt(userNameId);
            orderId = Integer.parseInt(Id);
        } catch (Exception e) {
            e.getStackTrace();
        }
        String stt = "unpaid";
        lstOrder = controller.DeleteGioHang(orderId, userId,stt);
        for (int i = 0; i < lstOrder.size(); i++) {
            tongsotien += lstOrder.get(i).getFinistnum();
        }
        lstProduct = controller.getAllProductDelete();
        return SUCCESS;
    }

    public String getCartbyName() {
        return SUCCESS;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Userkey getUserkey() {
        return userkey;
    }

    public void setUserkey(Userkey userkey) {
        this.userkey = userkey;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public ControllerGioHang getController() {
        return controller;
    }

    public void setController(ControllerGioHang controller) {
        this.controller = controller;
    }

    public List<Userkey> getLstUser() {
        return lstUser;
    }

    public void setLstUser(List<Userkey> lstUser) {
        this.lstUser = lstUser;
    }

    public List<Product> getLstProduct() {
        return lstProduct;
    }

    public void setLstProduct(List<Product> lstProduct) {
        this.lstProduct = lstProduct;
    }

    public Product getProductbyId() {
        return productbyId;
    }

    public void setProductbyId(Product productbyId) {
        this.productbyId = productbyId;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Allorder getAllorder() {
        return allorder;
    }

    public void setAllorder(Allorder allorder) {
        this.allorder = allorder;
    }

    public List<Allorder> getLstOrder() {
        return lstOrder;
    }

    public void setLstOrder(List<Allorder> lstOrder) {
        this.lstOrder = lstOrder;
    }

    public List<Product> getListProductref() {
        return listProductref;
    }

    public void setListProductref(List<Product> listProductref) {
        this.listProductref = listProductref;
    }

    public int getTongsotien() {
        return tongsotien;
    }

    public void setTongsotien(int tongsotien) {
        this.tongsotien = tongsotien;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

}
