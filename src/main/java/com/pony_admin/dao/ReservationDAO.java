package com.pony_admin.dao;

import com.pony_admin.domain.ReservationEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/4
 */
public interface ReservationDAO {

    int insert(ReservationEntity reservationEntity);

    List<ReservationEntity> getAllReservationList();
    /**
     * 根据ID获取预约信息
     *
     * @param reservationId
     * @return ReservationEntity
     */
    ReservationEntity getReservationEntityById(@Param("reservationId") Integer reservationId);
}
