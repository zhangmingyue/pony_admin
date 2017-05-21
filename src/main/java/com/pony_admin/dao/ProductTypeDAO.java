package com.pony_admin.dao;

import com.pony_admin.Product.entity.ProductEntity;
import com.pony_admin.ProductType.entity.ProductType;
import com.pony_admin.ProductType.entity.ProductTypeQueryBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/5
 */
public interface ProductTypeDAO {
    /**
     * 添加产品分类
     *
     * @param productType
     * @return int
     */
    int insertProductType(ProductType productType);
    /**
     * 修改产品分类
     *
     * @param productType
     * @return int
     */
    int updateProductType(ProductType productType);
    /**
     * 删除产品分类
     *
     * @param productType
     * @return int
     */
    int deleteProductType(ProductType productType);
    /**
     * 根据id获取产品分类详细信息
     *
     * @param productTypeId
     * @return ProductType
     */
    public ProductType getProductTypeByProductTypeId(@Param("productTypeId") int productTypeId);
    /**
     * 根据产品分类ID获取子分类链表
     *
     * @param productTypeId
     * @return List<ProductType>
     */
    public List<ProductType> getChildProductTypeListByProductTypeId(@Param("productTypeId") int productTypeId);
    /**
     * 根据查询条件获取分类链表
     *
     * @param productTypeQueryBean
     * @return List<ProductType>
     */
    public List<ProductType> getProductTypeListByQuerybean(ProductTypeQueryBean productTypeQueryBean);
    /**
     * 根据查询分类ID获取产品列表
     *
     * @param productTypeId
     * @return List<ProductType>
     */
    public List<ProductEntity> getProductEntityListByProductTypeId(@Param("productTypeId") int productTypeId);
    /**
     * 添加产品
     *
     * @param productTypeId
     * @return int
     */
    public int addProductToProductType(@Param("productTypeId") int productTypeId,@Param("productId") int productId);
    /**
     * 删除产品
     *
     * @param productTypeId
     * @return int
     */
    public int deleteProductToProductType(@Param("productTypeId") int productTypeId,@Param("productId") int productId);

}
