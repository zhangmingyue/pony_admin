package com.pony_admin.service;

import com.pony_admin.domain.ResidentialAreaEntity;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
public interface ResidentialAreaService {

    int insert(ResidentialAreaEntity residentialAreaEntity);

    List<ResidentialAreaEntity> getAllList();

    ResidentialAreaEntity getResidentialById(int id);
}
