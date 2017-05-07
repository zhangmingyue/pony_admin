package com.pony_admin.dao;

import com.pony_admin.domain.DistrictEntity;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
public interface DistrictDAO {

    int insert(DistrictEntity districtEntity);

    List<DistrictEntity> getAllList();
}
