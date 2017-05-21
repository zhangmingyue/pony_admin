package com.pony_admin.ProductType.service;

import com.pony_admin.Product.entity.ProductEntity;
import com.pony_admin.ProductType.entity.ProductType;
import com.pony_admin.ProductType.entity.ProductTypeQueryBean;
import com.pony_admin.dao.ProductTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 广告serviceImpl
 * Created by Administrator on 2017/3/11 0011.
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDAO productTypeDAO;




    /**
     * 添加产品分类
     *
     * @param productType
     * @return int
     */
    public int insertProductType(ProductType productType){

       return productTypeDAO.insertProductType(productType);

    }

    /**
     * 修改产品分类
     *
     * @param productType
     * @return int
     */
    public int updateProductType(ProductType productType){

        return productTypeDAO.updateProductType(productType);

    }

    /**
     * 删除产品分类
     *
     * @param productType
     * @return int
     */
    public int deleteProductType(ProductType productType){

        return productTypeDAO.deleteProductType(productType);

    }

    /**
     * 根据id获取产品分类详细信息
     *
     * @param productTypeId
     * @return ProductType
     */
    public ProductType getProductTypeByProductTypeId(int productTypeId){

        ProductType productType = productTypeDAO.getProductTypeByProductTypeId(productTypeId);
        List<ProductType> productTypeList = productTypeDAO.getChildProductTypeListByProductTypeId(productTypeId);
        if(productTypeList == null){
            productTypeList = new ArrayList<ProductType>();
        }
        productType.setProductTypeList(productTypeList);
        return productType;

    }
    /**
     * 根据产品分类ID获取子分类链表
     *
     * @param productTypeId
     * @return List<ProductType>
     */
    public List<ProductType> getChildProductTypeListByProductTypeId(int productTypeId){
        return productTypeDAO.getChildProductTypeListByProductTypeId(productTypeId);
    }
    /**
     * 根据查询条件获取分类链表
     *
     * @param productTypeQueryBean
     * @return List<ProductType>
     */
    public List<ProductType> getProductTypeListByQuerybean(ProductTypeQueryBean productTypeQueryBean){
        return productTypeDAO.getProductTypeListByQuerybean(productTypeQueryBean);
    }
    /**
     * 根据查询分类ID获取产品列表
     *
     * @param productTypeId
     * @return List<ProductType>
     */
    public List<ProductEntity> getProductEntityListByProductTypeId(int productTypeId){
        return productTypeDAO.getProductEntityListByProductTypeId(productTypeId);
    }
    /**
     * 添加产品
     *
     * @param productTypeId
     * @return int
     */
    public int addProductToProductType(int productTypeId,int productId){
        return productTypeDAO.addProductToProductType(productTypeId,productId);
    }
    /**
     * 删除产品
     *
     * @param productTypeId
     * @return int
     */
    public int deleteProductToProductType(int productTypeId,int productId){
        return productTypeDAO.deleteProductToProductType(productTypeId,productId);
    }
}
