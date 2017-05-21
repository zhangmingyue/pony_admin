package com.pony_admin.service.Impl;

import com.pony_admin.dao.ReservationDAO;
import com.pony_admin.domain.ReservationEntity;
import com.pony_admin.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/4
 */
@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationDAO reservationDAO;

    @Override
    public int insert(ReservationEntity reservationEntity) {
        return reservationDAO.insert(reservationEntity);
    }

    @Override
    public List<ReservationEntity> getAllReservationName() {
        return reservationDAO.getAllReservationList();
    }
    /**
     * 根据ID获取预约信息
     *
     * @param reservationId
     * @return ReservationEntity
     */
    public ReservationEntity getReservationEntityById(Integer reservationId){
        return reservationDAO.getReservationEntityById(reservationId);
    }
}
