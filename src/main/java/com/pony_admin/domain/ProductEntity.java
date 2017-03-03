package com.pony_admin.domain;

import java.util.Date;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/2
 */
public class ProductEntity {
    private int id;
    //产品名
    private String productClassName;
    //促销价
    private double promotionPrice;
    //产品编号
    private String productNumber;
    //是否现货
    private int isSpot;
    //产品图标图片路径
    private String productIconUrl;
    //是否促销
    private int promotion;
    //排名权重
    private int weight;
    //长
    private int length;
    //高
    private int high;
    //宽
    private int width;
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

}
