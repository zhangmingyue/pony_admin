package com.pony_admin.ProductType.entity;

import lombok.experimental.Accessors;

import java.util.List;

/**
 * 专题
 * Created by zhangmingyue on 2017/3/2 0002.
 */
@Accessors(chain = true)
public class ProductType {

    private int id;
    //类目名称
    private String productTypeName;
    //父类目ID
    private int parentId;
    //子类目列表
    private List<ProductType> productTypeList;
    //产品类别图片URL
    private String productTypeIconUrl;
    //分类等级
    private int typeLevel;

    //getter and setter


    public int getTypeLevel() {
        return typeLevel;
    }

    public void setTypeLevel(int typeLevel) {
        this.typeLevel = typeLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<ProductType> getProductTypeList() {
        return productTypeList;
    }

    public void setProductTypeList(List<ProductType> productTypeList) {
        this.productTypeList = productTypeList;
    }

    public String getProductTypeIconUrl() {
        return productTypeIconUrl;
    }

    public void setProductTypeIconUrl(String productTypeIconUrl) {
        this.productTypeIconUrl = productTypeIconUrl;
    }
}
