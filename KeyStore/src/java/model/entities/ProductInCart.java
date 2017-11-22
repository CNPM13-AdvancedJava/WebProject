/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.util.List;

/**
 *
 * @author Linh
 */
public class ProductInCart {
    private Integer productId;
    private String productName;
    private String productImage;
    private Double price;
    private String priceStr;
    private Integer number;
    private Double totalPrice;
    private String totalPriceStr;

    public static Double getTotalPayment(List<ProductInCart> lstProduct){
        Double total = 0.0;
        for (ProductInCart item : lstProduct){
            total += item.totalPrice;
        }
        return total;
    }
    
    public ProductInCart() {
    }

    public ProductInCart(Integer productId, Double price, Integer number) {
        this.productId = productId;
        this.price = price;
        this.number = number;
    }

    public ProductInCart(Integer productId, String productName, String productImage, Double price, Integer number, Double totalPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.price = price;
        this.number = number;
        this.totalPrice = totalPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    public String getTotalPriceStr() {
        return totalPriceStr;
    }

    public void setTotalPriceStr(String totalPriceStr) {
        this.totalPriceStr = totalPriceStr;
    }
    
}
