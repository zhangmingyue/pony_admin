package com.pony_admin.service.Impl;

import com.pony_admin.dao.ProductDAO;
import com.pony_admin.domain.ProductEntity;
import com.pony_admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
