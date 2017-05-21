package com.pony_admin.Product.service;

import com.pony_admin.Product.entity.ProductEntity;
import com.pony_admin.Product.entity.querybean.ProductQueryBean;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/5
 */
public interface ProductService {
    int insert(ProductEntity productEntity);

    int updateProductId(String productId, int id);

    String productNumberBuilder(int level1, int level2, int level3, int number);
    /**
     * 根据产品编码获取商品详细信息
     *
     * @param productNumber
     * @return ProductEntity
     */
    public ProductEntity getProductByProductNumber(String productNumber);
    /**
     * 根据产品编码获取商品详细信息
     *
     * @param productId
     * @return ProductEntity
     */
    public ProductEntity getProductByProductId(int productId);
    /**
     * 根据查询条件获取产品列表
     *
     * @param productQueryBean
     * @return List<ProductEntity>
     */
    public List<ProductEntity> getProductListByQuerybean(ProductQueryBean productQueryBean);
    /**
     * 产品修改
     *
     * @param productEntity
     * @return int
     */
    public int updateProduct(ProductEntity productEntity);
    /**
     * 产品促销信息修改
     *
     * @param productEntity
     * @return int
     */
    public int updateProductPromotion(ProductEntity productEntity);

}
