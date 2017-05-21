package com.pony_admin.Product.entity;

import java.util.Date;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/8
 */
public class ProductPriceEntity {
    private int id;
    private int productId;
    private double price;
    private Date enableDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getEnableDate() {
        return enableDate;
    }

    public void setEnableDate(Date enableDate) {
        this.enableDate = enableDate;
    }

    @Override
    public String toString() {
        return "ProductPriceEntity{" +
                "id=" + id +
                ", productId=" + productId +
                ", price=" + price +
                ", enableDate=" + enableDate +
                '}';
    }
}
