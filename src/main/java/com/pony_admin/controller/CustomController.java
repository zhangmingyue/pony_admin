package com.pony_admin.controller;

import com.pony_admin.domain.CategoryEntity;
import com.pony_admin.domain.ProductEntity;
import com.pony_admin.domain.ReservationEntity;
import com.pony_admin.enumeration.CategoryType;
import com.pony_admin.service.CategoryService;
import com.pony_admin.service.Impl.OSSService;
import com.pony_admin.service.ReservationService;
import com.pony_admin.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/1
 */
@Controller
@RequestMapping("/custom")
public class CustomController {

    private static final String BUCKET_NAME = "pony-custom";
    private static final String pattern = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    OSSService ossService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ReservationService reservationService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    String customs(Model model,
                   HttpServletRequest request,
                   HttpServletResponse response
    ) throws IOException {
        List<CategoryEntity> list = categoryService.getCategoryByType(CategoryType.level1);
        List<ReservationEntity> reservation = reservationService.getAllReservationName();

        model.addAttribute("level1", list);
        model.addAttribute("reservation", reservation);
        return "custom";
    }


    @RequestMapping(value = "/input", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> inputCustoms(Model model,
                                            HttpServletRequest request,
                                            HttpServletResponse response
    ) throws IOException, ParseException {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        String level1 = request.getParameter("org1");
        String level2 = request.getParameter("org2");
        String level3 = request.getParameter("org3");
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
        String promotion = request.getParameter("promotion");
        String promotionNumber = request.getParameter("promotion_number");
        String beginTime = request.getParameter("beginTime");
        String endTime = request.getParameter("endTime");
        String idRestrictionNumber = request.getParameter("id_restriction_number");
        String creditScore = request.getParameter("credit_score");
        String promotionPrice = request.getParameter("promotion_price");

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        long time = System.currentTimeMillis();
        String timeStr = String.valueOf(time);
        Date date = new Date(time);

        MultipartFile mainPic = multipartRequest.getFile("main_pic");
        String mainPicUrl = ossService.savePicAndGetUrl(mainPic.getInputStream(), BUCKET_NAME, mainPic + timeStr);

        MultipartFile pic1 = multipartRequest.getFile("pic1");
        String pic1Url = ossService.savePicAndGetUrl(mainPic.getInputStream(), BUCKET_NAME, pic1 + timeStr);

        MultipartFile pic2 = multipartRequest.getFile("pic2");
        String pic2Url = ossService.savePicAndGetUrl(mainPic.getInputStream(), BUCKET_NAME, pic2 + timeStr);

        MultipartFile pic3 = multipartRequest.getFile("pic3");
        String pic3Url = ossService.savePicAndGetUrl(mainPic.getInputStream(), BUCKET_NAME, pic3 + timeStr);

        MultipartFile pic4 = multipartRequest.getFile("pic4");
        String pic4Url = ossService.savePicAndGetUrl(mainPic.getInputStream(), BUCKET_NAME, pic4 + timeStr);

        MultipartFile pic5 = multipartRequest.getFile("pic5");
        String pic5Url = ossService.savePicAndGetUrl(mainPic.getInputStream(), BUCKET_NAME, pic5 + timeStr);

        MultipartFile pic6 = multipartRequest.getFile("pic6");
        String pic6Url = ossService.savePicAndGetUrl(mainPic.getInputStream(), BUCKET_NAME, pic6 + timeStr);

        MultipartFile pic7 = multipartRequest.getFile("pic7");
        String pic7Url = ossService.savePicAndGetUrl(mainPic.getInputStream(), BUCKET_NAME, pic7 + timeStr);

        MultipartFile pic8 = multipartRequest.getFile("pic8");
        String pic8Url = ossService.savePicAndGetUrl(mainPic.getInputStream(), BUCKET_NAME, pic8 + timeStr);

        MultipartFile pic9 = multipartRequest.getFile("pic9");
        String pic9Url = ossService.savePicAndGetUrl(mainPic.getInputStream(), BUCKET_NAME, pic9 + timeStr);

        MultipartFile pic10 = multipartRequest.getFile("pic10");
        String pic10Url = ossService.savePicAndGetUrl(mainPic.getInputStream(), BUCKET_NAME, pic10 + timeStr);

        ProductEntity productEntity = new ProductEntity();

        //类目
        productEntity.setCategoryCodeOne(level1);
        productEntity.setCategoryCodetTwo(level2);
        productEntity.setCategoryCodeThree(level3);
        //商品类型
        productEntity.setIsSpot(Integer.parseInt(productType));
        productEntity.setReservation(reservationType);
        //商品标题
        productEntity.setProductName(title);
        //TODO 商品价格
        //商品体积
        productEntity.setLength(Integer.parseInt(length));
        productEntity.setWidth(Integer.parseInt(width));
        productEntity.setHigh(Integer.parseInt(heigh));
        //TODO 最低预警库存
        //商品权重
        productEntity.setWeight(Integer.parseInt(privilege));
        //是否为促销商品
        productEntity.setPromotion(Integer.parseInt(promotion));
        productEntity.setPromotionNumber(Integer.parseInt(promotionNumber));
        productEntity.setPromotionBeginTime(TimeUtil.parse(beginTime, pattern));
        productEntity.setPromotionEndTime(TimeUtil.parse(endTime, pattern));
        productEntity.setPromotionPrice(Double.parseDouble(promotionPrice));
        //促销ID限购量
        productEntity.setIdRestrictionNumber(Integer.parseInt(idRestrictionNumber));
        //信用分数限制
        productEntity.setCreditScore(Integer.parseInt(creditScore));
        //主图片
        productEntity.setProductIconUrl(mainPicUrl);


        productEntity.setProductNumber("absdbajdb");


        List<CategoryEntity> list = categoryService.getCategoryByType("1");
        modelMap.put("orgList", list);
        modelMap.put("result", true);

        return modelMap;
    }
}
