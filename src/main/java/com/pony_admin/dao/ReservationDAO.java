package com.pony_admin.dao;

import com.pony_admin.domain.ReservationEntity;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/4
 */
public interface ReservationDAO {

    int insert(ReservationEntity reservationEntity);

    List<ReservationEntity> getAllReservationList();
}
