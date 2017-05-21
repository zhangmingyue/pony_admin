package com.pony_admin.Product.entity;

import java.util.Date;
import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/2
 */
public class ProductPromotionEntity {
    private int productId;

    //促销价
    private double promotionPrice;
    //是否促销
    private int promotionType;
    //促销开始时间
    private Date promotionBeginTime;
    //促销结束时间
    private Date promotionEndTime;
    //ID限购量
    private int idRestrictionNumber;
    //限购信用分数
    private int creditScore;
    //参与促销数量
    private int promotionNumber;
    //参与促销原始数量
    private int promotionNumberOriginal;

    //setter and getter


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public int getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(int promotionType) {
        this.promotionType = promotionType;
    }

    public Date getPromotionBeginTime() {
        return promotionBeginTime;
    }

    public void setPromotionBeginTime(Date promotionBeginTime) {
        this.promotionBeginTime = promotionBeginTime;
    }

    public Date getPromotionEndTime() {
        return promotionEndTime;
    }

    public void setPromotionEndTime(Date promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    public int getIdRestrictionNumber() {
        return idRestrictionNumber;
    }

    public void setIdRestrictionNumber(int idRestrictionNumber) {
        this.idRestrictionNumber = idRestrictionNumber;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getPromotionNumber() {
        return promotionNumber;
    }

    public void setPromotionNumber(int promotionNumber) {
        this.promotionNumber = promotionNumber;
    }

    public int getPromotionNumberOriginal() {
        return promotionNumberOriginal;
    }

    public void setPromotionNumberOriginal(int promotionNumberOriginal) {
        this.promotionNumberOriginal = promotionNumberOriginal;
    }
}
