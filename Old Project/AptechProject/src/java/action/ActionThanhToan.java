/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import controller.ControllerThanhToan;
import entities.Product;
import entities.Userkey;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import util.SendEmail;
import util.SendSMS;

/**
 *
 * @author Nguyen
 */
public class ActionThanhToan extends ActionSupport implements ServletRequestAware {

    private int soTienthanhToan;
    private int soLuongthanhToan;
    private Product product;
    private Userkey user;
    private HttpServletRequest request;
    private ControllerThanhToan controller;
    private List<Userkey> lstUser = new ArrayList<Userkey>();

    public ActionThanhToan() {
        controller = new ControllerThanhToan();
    }

    public String getMoneyforThanhtoan() {
        String mony = request.getParameter("giaSponeChamp");
        String proId = request.getParameter("productThanhtoanId");
        String numbe = request.getParameter("text-number-son");
        int money = 0;
        int number = 0;
        int productId = 0;
        try {
            productId = Integer.parseInt(proId);
            money = Integer.parseInt(mony);
            number = Integer.parseInt(numbe);
        } catch (Exception e) {
            e.printStackTrace();
        }
        product = controller.getProductbyId(productId);
        soTienthanhToan = number * money;
        soLuongthanhToan = number;
        return SUCCESS;
    }

    public String thanhToan1Sp() {
        String userName = request.getParameter("userNamettSP");
        String tienThanhtoan = request.getParameter("tienCanThanhToan");
        lstUser = controller.getUserbyName(userName);
        int userId = lstUser.get(0).getUserId();
        int taikhoan = lstUser.get(0).getMoney();
        int tienctt = 0;
        int kq = 0;
        try {
            tienctt = Integer.parseInt(tienThanhtoan);
        } catch (Exception e) {
            e.getStackTrace();
        }
        kq = taikhoan - tienctt;
        if (kq > 0) {
            String recipient = lstUser.get(0).getUserName();
            String subject = "Thanh toán thành công";
            String message = "Bạn vừa thanh toán thành công số tiền : " + tienctt + " đ trong tài khoản " + lstUser.get(0).getUserName() + " tại KEYWORLD.VN";
            //Thong tin SMS
            String phone = lstUser.get(0).getUserPhonenum();
            String sms = "Thanh toán số tiền : " + tienctt + "";
            boolean check = controller.updateMoney(userId, kq);
            if (check == true) {
                try {
                    SendEmail sendemail = new SendEmail();
                    SendSMS sendsms = new SendSMS();
                    boolean checkSendMail = sendemail.doSendEmail(recipient, subject, message);
                    boolean checkSendSMS = sendsms.sendSMSCustomer(phone, sms);
                    if (checkSendMail == false || checkSendSMS == false) {
                        return ERROR;
                    }
                } catch (Exception e) {
                    e.getStackTrace();
                    return ERROR;
                }
            }
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String thanhToanGH() {
        String userName = request.getParameter("userNameTTGH");
        String tienThanhtoan = request.getParameter("tienTTGH");
        lstUser = controller.getUserGH(userName);
        int userId = lstUser.get(0).getUserId();
        int taikhoan = lstUser.get(0).getMoney();
        int tienctt = 0;
        int kq = 0;
        try {
            tienctt = Integer.parseInt(tienThanhtoan);
        } catch (Exception e) {
            e.getStackTrace();
        }
        kq = taikhoan - tienctt;
        if (kq > 0) {
            String recipient = lstUser.get(0).getUserName();
            String subject = "Thanh toán thành công";
            String message = "Bạn vừa thanh toán thành công số tiền : " + tienctt + " đ trong tài khoản " + lstUser.get(0).getUserName() + " tại KEYWORLD.VN";
            //Thong tin SMS
            String phone = lstUser.get(0).getUserPhonenum();
            String sms = "Thanh toán số tiền : " + tienctt + "";
            boolean check = controller.updateMoneyGH(userId, kq);
            if (check == true) {
                try {
                    SendEmail sendemail = new SendEmail();
                    SendSMS sendsms = new SendSMS();
                    boolean checkSendMail = sendemail.doSendEmail(recipient, subject, message);
                    boolean checkSendSMS = sendsms.sendSMSCustomer(phone, sms);
                    if (checkSendMail == false || checkSendSMS == false) {
                        return ERROR;
                    }
                } catch (Exception e) {
                    e.getStackTrace();
                    return ERROR;
                }
            }
            String stt = "paid";
            controller.deleteOrderbyuserId(userId, stt);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String ThanhtoaninPay() {
        String ttk = request.getParameter("sotaikhoan");
        String mktk = request.getParameter("matkhau");
        String sttt = request.getParameter("sotienTT");
        String user = request.getParameter("userNamettPay");
        lstUser = controller.getUserbyPay(user);
        int sotienTT = 0;
        float moneyMer = 0;
        try {
            moneyMer = Float.parseFloat(sttt);
            sotienTT = Integer.parseInt(sttt);
        } catch (Exception e) {
            e.getStackTrace();
        }
        String merchanId = "Merchan1";
        String mtknh = "21710000044991";
        int transId = checkOrder(merchanId, ttk, mktk);
        if (transId != 0) {
            String check = finishOrder(transId, mtknh, moneyMer);
            if (check.equals("success")) {
                String recipient = lstUser.get(0).getUserName();
                String subject = "Thanh toán thành công";
                String message = "Bạn vừa thanh toán thành công số tiền : " + sotienTT + " đ trong tài khoản " + lstUser.get(0).getUserName() + " tại KEYWORLD.VN";
                //Thong tin SMS
                String phone = lstUser.get(0).getUserPhonenum();
                String sms = "Thanh toán số tiền : " + sttt + "";
                try {
                    SendEmail sendemail = new SendEmail();
                    SendSMS sendsms = new SendSMS();
                    boolean checkSendMail = sendemail.doSendEmail(recipient, subject, message);
                    boolean checkSendSMS = sendsms.sendSMSCustomer(phone, sms);
                    if (checkSendMail == false || checkSendSMS == false) {
                        return ERROR;
                    }
                } catch (Exception e) {
                    e.getStackTrace();
                    return ERROR;
                }
                return SUCCESS;
            } else {
                return ERROR;
            }
        } else {
            return ERROR;
        }

    }

    public String thanhToanbyinGH() {
        String ttk = request.getParameter("tentaikhoan");
        String mktk = request.getParameter("matkhau");
        String sttt = request.getParameter("sotienTT");
        String user = request.getParameter("userNamettPay");
        lstUser = controller.getUserbyPay(user);
        int userId = lstUser.get(0).getUserId();
        int sotienTT = 0;
        float moneyMer = 0;
        try {
            moneyMer = Float.parseFloat(sttt);
            sotienTT = Integer.parseInt(sttt);
        } catch (Exception e) {
            e.getStackTrace();
        }

        String merchanId = "Merchan1";
        String mtknh = "21710000044991";
        int transId = checkOrder(merchanId, ttk, mktk);
        if (transId != 0) {
            String check = finishOrder(transId, mtknh, moneyMer);
            if (check.equals("success")) {
                String recipient = lstUser.get(0).getUserName();
                String subject = "Thanh toán thành công";
                String message = "Bạn vừa thanh toán thành công số tiền : " + sotienTT + " đ trong tài khoản " + lstUser.get(0).getUserName() + " tại KEYWORLD.VN";
                //Thong tin SMS
                String phone = lstUser.get(0).getUserPhonenum();
                String sms = "Thanh toán số tiền : " + sttt + "";
                try {
                    SendEmail sendemail = new SendEmail();
                    SendSMS sendsms = new SendSMS();
                    boolean checkSendMail = sendemail.doSendEmail(recipient, subject, message);
                    boolean checkSendSMS = sendsms.sendSMSCustomer(phone, sms);
                    if (checkSendMail == false || checkSendSMS == false) {
                        return ERROR;
                    }
                } catch (Exception e) {
                    e.getStackTrace();
                    return ERROR;
                }
                String stt = "paid";
                controller.deleteOrderbyuserIdPay(userId, stt);
                return SUCCESS;
            } else {
                return ERROR;
            }
        } else {
            return ERROR;
        }
    }

    public int getSoTienthanhToan() {
        return soTienthanhToan;
    }

    public void setSoTienthanhToan(int soTienthanhToan) {
        this.soTienthanhToan = soTienthanhToan;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public ControllerThanhToan getController() {
        return controller;
    }

    public void setController(ControllerThanhToan controller) {
        this.controller = controller;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Userkey getUser() {
        return user;
    }

    public void setUser(Userkey user) {
        this.user = user;
    }

    public int getSoLuongthanhToan() {
        return soLuongthanhToan;
    }

    public void setSoLuongthanhToan(int soLuongthanhToan) {
        this.soLuongthanhToan = soLuongthanhToan;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    private static int checkOrder(java.lang.String merchantId, java.lang.String userName, java.lang.String password) {
        service.PaymentService_Service service = new service.PaymentService_Service();
        service.PaymentService port = service.getPaymentServicePort();
        return port.checkOrder(merchantId, userName, password);
    }

    private static String finishOrder(int transactionId, java.lang.String account, float amount) {
        service.PaymentService_Service service = new service.PaymentService_Service();
        service.PaymentService port = service.getPaymentServicePort();
        return port.finishOrder(transactionId, account, amount);
    }
}
