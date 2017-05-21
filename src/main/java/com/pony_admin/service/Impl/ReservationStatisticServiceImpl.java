package com.pony_admin.service.Impl;

import com.pony_admin.dao.ReservationStatisticDAO;
import com.pony_admin.domain.ReservationStatisticEntity;
import com.pony_admin.service.ReservationStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/20
 */
@Service
public class ReservationStatisticServiceImpl implements ReservationStatisticService {
    @Autowired
    ReservationStatisticDAO reservationStatisticDAO;

    @Override
    public List<ReservationStatisticEntity> getListByTime(Date beginTime, Date endTime) {
        return reservationStatisticDAO.getListByTime(beginTime, endTime);
    }
}
