package com.pony_admin.controller;

import com.google.common.base.Strings;
import com.pony_admin.domain.ReservationStatisticEntity;
import com.pony_admin.service.ReservationStatisticService;
import com.pony_admin.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/20
 */
@Controller
@RequestMapping(value = "statistic")
public class DataStatisticController {
    @Autowired
    ReservationStatisticService reservationStatisticService;

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    @RequestMapping(value = "reservation", method = RequestMethod.GET)
    public String getAdminPage(Model model,
                               HttpServletRequest request,
                               HttpServletResponse response) throws ParseException {

        String beginTimeStr = request.getParameter("beginTime");
        String endTimeStr = request.getParameter("endTime");

        Date beginTime = TimeUtil.parse(beginTimeStr, PATTERN);
        Date endTime = TimeUtil.parse(endTimeStr, PATTERN);
        if (Strings.isNullOrEmpty(beginTimeStr)
                && Strings.isNullOrEmpty(endTimeStr)) {
            endTime = new Date();
            beginTimeStr = TimeUtil.parseTime(endTime.getTime() - 86400000);
            beginTime = TimeUtil.parse(beginTimeStr, "yyyy-MM-dd HH:mm:ss");
        }

        List<ReservationStatisticEntity> reservation = reservationStatisticService.getListByTime(beginTime, endTime);
        model.addAttribute("reservationList", reservation);
        return "reservation_statistic";
    }
}
