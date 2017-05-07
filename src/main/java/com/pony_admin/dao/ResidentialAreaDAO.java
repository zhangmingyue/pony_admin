package com.pony_admin.dao;

import com.pony_admin.domain.ResidentialAreaEntity;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
public interface ResidentialAreaDAO {

    int insert(ResidentialAreaEntity residentialAreaEntity);

    List<ResidentialAreaEntity> getAllList();

    ResidentialAreaEntity getResidentialById(int id);
}
