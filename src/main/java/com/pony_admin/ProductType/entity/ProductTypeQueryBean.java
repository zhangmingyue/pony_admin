package com.pony_admin.ProductType.entity;

import lombok.experimental.Accessors;

import java.util.List;

/**
 * 专题
 * Created by zhangmingyue on 2017/3/2 0002.
 */

public class ProductTypeQueryBean {

    //类目名称
    private String productTypeName;

    //分类等级
    private int typeLevel;

    //getter and setter


    public int getTypeLevel() {
        return typeLevel;
    }

    public void setTypeLevel(int typeLevel) {
        this.typeLevel = typeLevel;
    }


    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
}
