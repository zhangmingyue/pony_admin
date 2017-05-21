package com.pony_admin.domain;

import java.util.Date;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/20
 */
public class ReservationStatisticEntity {
    private int id;
    //预约类型ID
    private int reservationId;
    //产品名称
    private String productName;
    //产品编码
    private String productNumber;
    //产品单位
    private String unit;
    //产品ID
    private int productId;
    //预约购买数量
    private int reservationNumber;
    //提货日期
    private Date deliveryDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "DataController{" +
                "id=" + id +
                ", reservationId=" + reservationId +
                ", productName='" + productName + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", unit='" + unit + '\'' +
                ", productId=" + productId +
                ", reservationNumber=" + reservationNumber +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
