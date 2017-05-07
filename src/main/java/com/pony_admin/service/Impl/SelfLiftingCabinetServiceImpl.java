package com.pony_admin.service.Impl;

import com.pony_admin.dao.SelfLiftingCabinetDAO;
import com.pony_admin.domain.SelfLiftingCabinetEntity;
import com.pony_admin.service.SelfLiftingCabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
@Service
public class SelfLiftingCabinetServiceImpl implements SelfLiftingCabinetService {

    @Autowired
    SelfLiftingCabinetDAO selfLiftingCabinetDAO;

    @Override
    public int insert(SelfLiftingCabinetEntity selfLiftingCabinetEntity) {
        return selfLiftingCabinetDAO.insert(selfLiftingCabinetEntity);
    }
}
