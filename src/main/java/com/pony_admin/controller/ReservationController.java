package com.pony_admin.controller;

import com.pony_admin.domain.ReservationEntity;
import com.pony_admin.service.Impl.OSSService;
import com.pony_admin.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/4
 */

@Controller
@RequestMapping(value = "/reservation")
public class ReservationController {
    private static final String BUCKET_NAME = "pony-reservation";
    @Autowired
    OSSService ossService;
    @Autowired
    ReservationService reservationService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String reservationShow(Model model,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        return "reservation";
    }

    @RequestMapping(value = "/input", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> reservationAdd(HttpServletRequest request,
                                              HttpServletResponse response) throws IOException {
        Map<String, Object> model = new HashMap<>();
        String reservation = request.getParameter("reservation");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("pic");

        long time = System.currentTimeMillis();
        String timeStr = String.valueOf(time);
        Date date = new Date(time);

        String url = ossService.savePicAndGetUrl(file.getInputStream(), BUCKET_NAME, reservation + timeStr);
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setName(reservation);
        reservationEntity.setUrl(url);
        reservationEntity.setDate(date);
        int result = reservationService.insert(reservationEntity);

        return model;
    }
}
