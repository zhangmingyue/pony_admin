package com.pony_admin.service.Impl;

import com.pony_admin.dao.ResidentialAreaDAO;
import com.pony_admin.domain.ResidentialAreaEntity;
import com.pony_admin.service.ResidentialAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
@Service
public class ResidentailAreaSeriveImpl implements ResidentialAreaService {

    @Autowired
    ResidentialAreaDAO residentialAreaDAO;

    @Override
    public int insert(ResidentialAreaEntity residentialAreaEntity) {
        return residentialAreaDAO.insert(residentialAreaEntity);
    }

    @Override
    public List<ResidentialAreaEntity> getAllList() {
        return residentialAreaDAO.getAllList();
    }

    @Override
    public ResidentialAreaEntity getResidentialById(int id) {
        return residentialAreaDAO.getResidentialById(id);
    }
}
