package com.pony_admin.service.Impl;

import com.pony_admin.dao.CategoryDAO;
import com.pony_admin.domain.CategoryEntity;
import com.pony_admin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/3
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO category;

    @Override
    public int insert(CategoryEntity categoryEntity) {
        return category.insert(categoryEntity);
    }

    @Override
    public List<CategoryEntity> getCategoryByType(String type) {
        return category.getCategoryByType(type);
    }

    @Override
    public List<CategoryEntity> getCategoryByParent(String parent) {
        return category.getCategoryByParent(parent);
    }
}
