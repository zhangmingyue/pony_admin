package com.pony_admin.Product.entity.querybean;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class ProductQueryBean {

    //产品ID
    private int productId;
    //产品编码
    private String productNumber;
    //一级分类
    private String categoryCodeOne;
    //一级分类
    private String categoryCodeTwo;
    //一级分类
    private String categoryCodeThree;
    //预约类型
    private int reservationType;

    //getter and setter


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getCategoryCodeOne() {
        return categoryCodeOne;
    }

    public void setCategoryCodeOne(String categoryCodeOne) {
        this.categoryCodeOne = categoryCodeOne;
    }

    public String getCategoryCodeTwo() {
        return categoryCodeTwo;
    }

    public void setCategoryCodeTwo(String categoryCodeTwo) {
        this.categoryCodeTwo = categoryCodeTwo;
    }

    public String getCategoryCodeThree() {
        return categoryCodeThree;
    }

    public void setCategoryCodeThree(String categoryCodeThree) {
        this.categoryCodeThree = categoryCodeThree;
    }

    public int getReservationType() {
        return reservationType;
    }

    public void setReservationType(int reservationType) {
        this.reservationType = reservationType;
    }
}
