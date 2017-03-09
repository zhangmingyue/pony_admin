package com.pony_admin.service.Impl;

import com.pony_admin.dao.ProductPriceDAO;
import com.pony_admin.domain.ProductPriceEntity;
import com.pony_admin.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
