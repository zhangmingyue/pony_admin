package com.pony_admin.dao;

import com.pony_admin.domain.CategoryEntity;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/3
 */
public interface CategoryDAO {

    int insert(CategoryEntity categoryEntity);

    List<CategoryEntity> getCategoryByType(String type);
}
