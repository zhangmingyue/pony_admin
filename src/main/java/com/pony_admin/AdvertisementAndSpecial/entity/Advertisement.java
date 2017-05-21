package com.pony_admin.AdvertisementAndSpecial.entity;

import com.pony_admin.Product.entity.ProductEntity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangmingyue on 2017/3/2 0002.
 * 广告类
 */
public class Advertisement {

    private int id;
    //广告图片URL
    private String advertisementPictureUrl;
    //广告名称
    private String advertisementName;
    //广告投放开始时间
    private Date beginTime;
    //广告结束时间
    private Date endTime;
    //广告投放开始时间Page
    private String beginTimePage;
    //广告结束时间Page
    private String endTimePage;
    //广告权重
    private int weight;
    //广告关联产品ID
    private int productId;
    //广告图片高
    private int pictureHigh;
    //广告图片宽
    private int pictureWidth;
    //广告关联产品
    private ProductEntity productEntity;



    //setter and getter


    public String getBeginTimePage() {
        return beginTimePage;
    }

    public void setBeginTimePage(String beginTimePage) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            this.beginTime = dateFormat.parse(beginTimePage);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.beginTimePage = beginTimePage;
    }

    public String getEndTimePage() {
        return endTimePage;
    }

    public void setEndTimePage(String endTimePage) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            this.endTime = dateFormat.parse(endTimePage);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.endTimePage = endTimePage;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public String getAdvertisementName() {
        return advertisementName;
    }

    public void setAdvertisementName(String advertisementName) {
        this.advertisementName = advertisementName;
    }

    public int getPictureHigh() {
        return pictureHigh;
    }

    public void setPictureHigh(int pictureHigh) {
        this.pictureHigh = pictureHigh;
    }

    public int getPictureWidth() {
        return pictureWidth;
    }

    public void setPictureWidth(int pictureWidth) {
        this.pictureWidth = pictureWidth;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdvertisementPictureUrl() {
        return advertisementPictureUrl;
    }

    public void setAdvertisementPictureUrl(String advertisementPictureUrl) {
        this.advertisementPictureUrl = advertisementPictureUrl;
    }

    public String getBeginTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(beginTime);
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(endTime);
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
