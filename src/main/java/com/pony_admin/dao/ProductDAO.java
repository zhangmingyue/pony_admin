package com.pony_admin.dao;

import com.pony_admin.domain.ProductEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/5
 */
public interface ProductDAO {
    int insert(ProductEntity productEntity);

    int updateProductId(@Param("product_number") String productId, @Param("id") int id);
}
