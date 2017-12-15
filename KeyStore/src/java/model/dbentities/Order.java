package model.dbentities;
// Generated Nov 25, 2017 12:14:20 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Order generated by hbm2java
 */
public class Order implements java.io.Serializable {

    private Integer orderId;
    private PaymentMethod paymentMethod;
    private User user;
    private Integer status;
    private Double totalPrice;
    private Date orderTime;
    private Set orderDetails = new HashSet(0);

    private String stt;
    private Integer amount;

    public Order() {
    }

    public Order(PaymentMethod paymentMethod, User user, Integer status, Double totalPrice, Date orderTime, Set orderDetails) {
        this.paymentMethod = paymentMethod;
        this.user = user;
        this.status = status;
        this.totalPrice = totalPrice;
        this.orderTime = orderTime;
        this.orderDetails = orderDetails;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(Set orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
