package com.pony_admin.AdvertisementAndSpecial.entity;


import com.pony_admin.Product.entity.ProductEntity;
import lombok.experimental.Accessors;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 专题
 * Created by zhangmingyue on 2017/3/2 0002.
 */
@Accessors(chain = true)
public class Special {

    private int id;
    //专题题目
    private String title;
    //专题介绍
    private String specialIntroduction;
    //专题图片URL进入专题后最上面的图片
    private String specialPictureUrl;
    //专题封面图片url同广告图片
    private String coverPageUrl;
    //专题文本项列表
    private List<SpecialTextItem> SpecialTextItemList;
    //专题权重
    private int weight;
    //产品列表
    private List<ProductEntity> productList;
    //封面图片高
    private int coverPageHigh;
    //封面图片宽
    private int coverPageWidth;
    //责任编辑
    private String editor;
    //专题投放开始时间
    private String beginTime;
    //专题结束时间
    private String endTime;




    //setter and getter



    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getCoverPageHigh() {
        return coverPageHigh;
    }

    public void setCoverPageHigh(int coverPageHigh) {
        this.coverPageHigh = coverPageHigh;
    }

    public int getCoverPageWidth() {
        return coverPageWidth;
    }

    public void setCoverPageWidth(int coverPageWidth) {
        this.coverPageWidth = coverPageWidth;
    }

    public List<ProductEntity> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductEntity> productList) {
        this.productList = productList;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<SpecialTextItem> getSpecialTextItemList() {
        return SpecialTextItemList;
    }

    public void setSpecialTextItemList(List<SpecialTextItem> specialTextItemList) {
        SpecialTextItemList = specialTextItemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpecialIntroduction() {
        return specialIntroduction;
    }

    public void setSpecialIntroduction(String specialIntroduction) {
        this.specialIntroduction = specialIntroduction;
    }

    public String getSpecialPictureUrl() {
        return specialPictureUrl;
    }

    public void setSpecialPictureUrl(String specialPictureUrl) {
        this.specialPictureUrl = specialPictureUrl;
    }

    public String getCoverPageUrl() {
        return coverPageUrl;
    }

    public void setCoverPageUrl(String coverPageUrl) {
        this.coverPageUrl = coverPageUrl;
    }

    public String getBeginTime() {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return dateFormat.format(beginTime);
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.beginTime = dateFormat.format(beginTime);
    }
    public void setBeginTime(String beginTime) {

        this.beginTime = beginTime;
    }
    public String getEndTime() {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return dateFormat.format(endTime);
        return endTime;
    }
    public void setEndTime(Date endTime) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.endTime = dateFormat.format(endTime);
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
