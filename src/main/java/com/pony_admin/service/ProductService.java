package com.pony_admin.service;

import com.pony_admin.domain.ProductEntity;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/5
 */
public interface ProductService {
    int insert(ProductEntity productEntity);

    int updateProductId(String productId, int id);

    String productNumberBuilder(int level1, int level2, int level3, int number);
}
