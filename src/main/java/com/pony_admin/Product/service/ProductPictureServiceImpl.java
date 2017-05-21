package com.pony_admin.Product.service;

import com.pony_admin.dao.ProductPictureDAO;
import com.pony_admin.Product.entity.ProductPictureEntity;
import com.pony_admin.Product.service.ProductPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/8
 */
@Service
public class ProductPictureServiceImpl implements ProductPictureService {

    @Autowired
    ProductPictureDAO productPictureDAO;

    @Override
    public int insert(ProductPictureEntity productPictureEntity) {
        return productPictureDAO.insert(productPictureEntity);
    }
    /**
     * 根据产品图片id删除产品图片
     *
     * @param productPictureId
     * @return int
     */
    public int deleteProductPictureById(Integer productPictureId){
        return productPictureDAO.deleteProductPictureById(productPictureId);
    }
    /**
     * 根据产品ID获取产品图片列表
     *
     * @param productId
     * @return int
     */
    public List<ProductPictureEntity> getProductPictureEntityListByProductId(Integer productId){
        return productPictureDAO.getProductPictureEntityListByProductId(productId);
    }
}
