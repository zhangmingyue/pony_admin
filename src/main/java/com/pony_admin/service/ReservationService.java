package com.pony_admin.service;

import com.pony_admin.domain.ReservationEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/4
 */
public interface ReservationService {

    int insert(ReservationEntity reservationEntity);

    List<ReservationEntity> getAllReservationName();
    /**
     * 根据ID获取预约信息
     *
     * @param reservationId
     * @return ReservationEntity
     */
    ReservationEntity getReservationEntityById(Integer reservationId);
}
