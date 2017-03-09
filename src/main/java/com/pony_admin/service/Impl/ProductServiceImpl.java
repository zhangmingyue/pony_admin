package com.pony_admin.service.Impl;

import com.pony_admin.dao.ProductDAO;
import com.pony_admin.domain.ProductEntity;
import com.pony_admin.service.ProductService;
import org.apache.ibatis.annotations.Param;
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
}
