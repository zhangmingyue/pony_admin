package com.pony_admin.service.Impl;

import com.pony_admin.dao.DistrictDAO;
import com.pony_admin.domain.DistrictEntity;
import com.pony_admin.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    DistrictDAO districtDAO;

    @Override
    public int insert(DistrictEntity districtEntity) {
        return districtDAO.insert(districtEntity);
    }

    @Override
    public List<DistrictEntity> getAllList() {
        return districtDAO.getAllList();
    }
}
