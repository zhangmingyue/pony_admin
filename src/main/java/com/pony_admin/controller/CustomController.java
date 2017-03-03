package com.pony_admin.controller;

import com.pony_admin.service.Impl.OSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/1
 */
@Controller
@RequestMapping("/custom")
public class CustomController {
    @Autowired
    OSSService ossService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    String customs(Model model,
                   HttpServletRequest request,
                   HttpServletResponse response
    ) throws IOException {

        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("name", "qiaoyi");
        return "custom";
    }


    @RequestMapping(value = "/input", method = RequestMethod.POST)
    Map<String, Object> inputCustoms(Model model,
                                     HttpServletRequest request,
                                     HttpServletResponse response
    ) throws IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        String productType = request.getParameter("product_type");
        String reservationType = request.getParameter("reservation_type");
        String title = request.getParameter("title");
        String price = request.getParameter("price");
        String tomorrowPrice = request.getParameter("tomorrow_price");
        String length = request.getParameter("length");
        String width = request.getParameter("width");
        String heigh = request.getParameter("height");
        String unit = request.getParameter("unit");
        String low = request.getParameter("low");
        String privilege = request.getParameter("privilege");

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("main_pic");
        String resutl = ossService.savePicAndGetUrl(file.getInputStream(), "qiaoyitest");

        modelMap.put("result", true);

        return modelMap;
    }
}
