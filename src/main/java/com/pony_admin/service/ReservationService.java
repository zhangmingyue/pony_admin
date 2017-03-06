package com.pony_admin.service;

import com.pony_admin.domain.ReservationEntity;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/4
 */
public interface ReservationService {

    int insert(ReservationEntity reservationEntity);

    List<ReservationEntity> getAllReservationName();
}
