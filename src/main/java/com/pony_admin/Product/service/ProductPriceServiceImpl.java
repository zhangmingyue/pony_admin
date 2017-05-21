package com.pony_admin.Product.service;

import com.pony_admin.dao.ProductPriceDAO;
import com.pony_admin.Product.entity.ProductPriceEntity;
import com.pony_admin.Product.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/8
 */
@Service
public class ProductPriceServiceImpl implements ProductPriceService {

    @Autowired
    ProductPriceDAO productPriceDAO;

    @Override
    public int insert(ProductPriceEntity productPriceEntity) {
        return productPriceDAO.insert(productPriceEntity);
    }
    /**
     * 根据产品id查询产品价格列表
     *
     * @param productId
     * @return List<ProductPriceEntity>
     */
    public List<ProductPriceEntity> getProductPriceEntityListByProductId(Integer productId){
        return productPriceDAO.getProductPriceEntityListByProductId(productId);
    }
    /**
     * 产品价格删除方法
     *
     * @param productPriceId
     * @return int
     */
    public int deleteProductPriceById(Integer productPriceId){
        return productPriceDAO.deleteProductPriceById(productPriceId);
    }
}
