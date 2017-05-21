package com.pony_admin.Product.service;

import com.pony_admin.Product.entity.ProductPictureEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/8
 */
public interface ProductPictureService {
    int insert(ProductPictureEntity productPictureEntity);
    /**
     * 根据产品图片id删除产品图片
     *
     * @param productPictureId
     * @return int
     */
    int deleteProductPictureById(Integer productPictureId);
    /**
     * 根据产品ID获取产品图片列表
     *
     * @param productId
     * @return int
     */
    List<ProductPictureEntity> getProductPictureEntityListByProductId(Integer productId);

}
