package com.pony_admin.Product.service;

import com.pony_admin.Product.entity.ProductPriceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/8
 */
public interface ProductPriceService {
    int insert(ProductPriceEntity productPriceEntity);
    /**
     * 根据产品id查询产品价格列表
     *
     * @param productId
     * @return List<ProductPriceEntity>
     */
    List<ProductPriceEntity> getProductPriceEntityListByProductId(Integer productId);
    /**
     * 产品价格删除方法
     *
     * @param productPriceId
     * @return int
     */
    int deleteProductPriceById(Integer productPriceId);
}
