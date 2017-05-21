package com.pony_admin.service;

import com.pony_admin.domain.ReservationStatisticEntity;

import java.util.Date;
import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/20
 */
public interface ReservationStatisticService {

    List<ReservationStatisticEntity> getListByTime(Date beginTime, Date endTime);
}
