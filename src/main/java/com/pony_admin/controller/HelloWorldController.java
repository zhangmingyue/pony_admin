package com.pony_admin.controller;

import com.pony_admin.domain.ProductEntity;
import com.pony_admin.service.ProductService;
import com.pony_admin.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.Date;


/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/23
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {


    @GetMapping("/index")
    String index(Model model) {
//        Date date  = new Date();

//        ProductEntity productEntity = new ProductEntity();
//        productEntity.setProductName("name");
//        productEntity.setProductNumber("absdbajdb");
//        productEntity.setPromotionNumber(100);
//        productEntity.setIsSpot(0);
//        productEntity.setPromotion(90);
//        productEntity.setLength(80);
//        productEntity.setWidth(70);
//        productEntity.setHigh(90);
//        productEntity.setProductIconUrl("url");
//        productEntity.setWeight(50);
//        productEntity.setPromotionBeginTime(date);
//        productEntity.setPromotionEndTime(date);
//        productEntity.setIdRestrictionNumber(1);
//        productEntity.setPromotion(10);
//        productEntity.setCreditScore(100);

//        String level1 = request.getParameter("org1");
//        String level2 = request.getParameter("org2");
//        String level3 = request.getParameter("org3");
//
//
//        String productType = request.getParameter("product_type");
//        String reservationType = request.getParameter("reservation_type");
//        String title = request.getParameter("title");
//        String price = request.getParameter("price");
//        String tomorrowPrice = request.getParameter("tomorrow_price");
//        String length = request.getParameter("length");
//        String width = request.getParameter("width");
//        String heigh = request.getParameter("height");
//        String unit = request.getParameter("unit");
//        String low = request.getParameter("low");
//        String privilege = request.getParameter("privilege");

//        productEntity.setCategoryCodeOne("1");
//        productEntity.setCategoryCodeThree("3");
//        productEntity.setCategoryCodetTwo("2");
//        productService.insert(productEntity);
        return "index";
    }
}