package com.pony_admin.service;

import com.pony_admin.domain.CategoryEntity;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/3
 */
public interface CategoryService {

    int insert(CategoryEntity categoryEntity);

    List<CategoryEntity> getCategoryByType(String type);
}
