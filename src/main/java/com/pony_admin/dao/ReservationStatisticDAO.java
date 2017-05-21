package com.pony_admin.dao;

import com.pony_admin.domain.ReservationStatisticEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/20
 */
public interface ReservationStatisticDAO {

    List<ReservationStatisticEntity> getListByTime(@Param("beginTime") Date beginTime,
                                                   @Param("endTime") Date endTime);
}
