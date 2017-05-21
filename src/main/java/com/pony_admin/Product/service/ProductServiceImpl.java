package com.pony_admin.Product.service;

import com.pony_admin.Product.entity.querybean.ProductQueryBean;
import com.pony_admin.dao.ProductDAO;
import com.pony_admin.Product.entity.ProductEntity;
import com.pony_admin.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/5
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;

    @Override
    public int insert(ProductEntity productEntity) {
        return productDAO.insert(productEntity);
    }

    @Override
    public int updateProductId(String productId, int id) {
        return productDAO.updateProductId(productId, id);
    }

    public String productNumberBuilder(int level1, int level2, int level3, int number) {
        String level1Str = String.format("%03d", level1);
        String level2Str = String.format("%03d", level2);
        String level3Str = String.format("%03d", level3);
        String numberStr = String.format("%03d", number);

        return level1Str + "-" + level2Str + "-" + level3Str + "-" + numberStr;
    }
    /**
     * 根据产品编码获取商品详细信息
     *
     * @param productNumber
     * @return ProductEntity
     */
    public ProductEntity getProductByProductNumber(String productNumber){

        return productDAO.getProductByProductNumber(productNumber);

    }
    /**
     * 根据产品编码获取商品详细信息
     *
     * @param productId
     * @return ProductEntity
     */
    public ProductEntity getProductByProductId(int productId){

        return productDAO.getProductById(productId);

    }
    /**
     * 根据查询条件获取产品列表
     *
     * @param productQueryBean
     * @return List<ProductEntity>
     */
    public List<ProductEntity> getProductListByQuerybean(ProductQueryBean productQueryBean){
        return productDAO.getProductListByQuerybean(productQueryBean);
    }
    /**
     * 产品修改
     *
     * @param productEntity
     * @return int
     */
    public int updateProduct(ProductEntity productEntity){
        return productDAO.updateProduct(productEntity);
    }
    /**
     * 产品促销信息修改
     *
     * @param productEntity
     * @return int
     */
    public int updateProductPromotion(ProductEntity productEntity){
        return productDAO.updateProductPromotion(productEntity);
    }
}
