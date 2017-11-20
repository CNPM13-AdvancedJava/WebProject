/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

/**
 *
 * @author Linh
 */
public class ProductInCart {
    private Integer productId;
    private Double price;
    private Integer number;

    public ProductInCart() {
    }

    public ProductInCart(Integer productId, Double price, Integer number) {
        this.productId = productId;
        this.price = price;
        this.number = number;
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
    
}
