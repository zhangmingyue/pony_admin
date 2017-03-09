package com.pony_admin.service.Impl;

import com.pony_admin.dao.ProductPictureDAO;
import com.pony_admin.domain.ProductPictureEntity;
import com.pony_admin.service.ProductPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
