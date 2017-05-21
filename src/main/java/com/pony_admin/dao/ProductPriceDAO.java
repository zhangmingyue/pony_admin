package com.pony_admin.dao;

import com.pony_admin.Product.entity.ProductPriceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/8
 */
public interface ProductPriceDAO {
    /**
     * 产品价格添加方法
     *
     * @param productPriceEntity
     * @return int
     */
    int insert(ProductPriceEntity productPriceEntity);
    /**
     * 根据产品id查询产品价格列表
     *
     * @param productId
     * @return List<ProductPriceEntity>
     */
    List<ProductPriceEntity> getProductPriceEntityListByProductId(@Param("productId") Integer productId);
    /**
     * 产品价格删除方法
     *
     * @param productPriceId
     * @return int
     */
    int deleteProductPriceById(@Param("productPriceId") Integer productPriceId);
}
