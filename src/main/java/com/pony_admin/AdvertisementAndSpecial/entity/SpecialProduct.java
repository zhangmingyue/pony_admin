package com.pony_admin.AdvertisementAndSpecial.entity;


import com.pony_admin.Product.entity.ProductEntity;
import lombok.experimental.Accessors;

/**
 * 专题
 * Created by zhangmingyue on 2017/3/2 0002.
 */
@Accessors(chain = true)
public class SpecialProduct {

    private int id;
    //专题Id
    private int specialId;
    //产品ID
    private int productId;
    //产品实体类
    private ProductEntity productEntity;

    //setter and getter


    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpecialId() {
        return specialId;
    }

    public void setSpecialId(int specialId) {
        this.specialId = specialId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
