/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import model.dbentities.ProductDetail;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import util.Util;

/**
 *
 * @author Linh
 */
public class Product {
    private Integer productId;
    private String productName;
    private String manufacturerName;
    private String typeName;
    private String releaseTime;
    private String status;
    private String language;
    private String region;
    private String description;
    private String introduction;
    private String price;
    private String thumbnailUrl;
    
    private List<ProductDetail> lstProduct;
    private List<String> imageUrl;

    public Product(ProductDetail detail) {
        NumberFormat formater = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        this.productId = detail.getProductId();
        this.productName = detail.getProductName();
        this.manufacturerName = detail.getManufacturer().getManufacturerName();
        this.typeName = detail.getType().getTypeName();
        this.releaseTime = DateFormat.getInstance().format(detail.getReleaseTime());
        if (detail.getStatus() == 1){
            this.status = "Sẵn có";
        }
        else {
            this.status = "Hết hàng";
        }
        this.language = detail.getLanguage();
        this.region = detail.getRegion();
        this.description = detail.getDescription();
        this.introduction = detail.getIntroduction();
        this.price = Util.formatPrice(detail.getPrice());
        this.thumbnailUrl = detail.getThumbnailUrl();
    }
    
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<ProductDetail> getLstProduct() {
        return lstProduct;
    }

    public void setLstProduct(List<ProductDetail> lstProduct) {
        this.lstProduct = lstProduct;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
    
    
}
