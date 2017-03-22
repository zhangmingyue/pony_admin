package com.pony_admin.controller;

import com.pony_admin.domain.*;
import com.pony_admin.enumeration.CategoryType;
import com.pony_admin.service.*;
import com.pony_admin.service.Impl.OSSService;
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
    @Autowired
    ProductService productService;
    @Autowired
    ProductPictureService productPictureService;
    @Autowired
    ProductPriceService productPriceService;

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
    public Map<String, Object> inputCustoms(HttpServletRequest request,
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
        String length = request.getParameter("length");
        String width = request.getParameter("width");
        String heigh = request.getParameter("height");
        String unit = request.getParameter("unit");
        String low = request.getParameter("low");
        String privilege = request.getParameter("privilege");
        String beginTime = request.getParameter("beginTime");

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        long time = System.currentTimeMillis();
        String timeStr = String.valueOf(time);
        Date date = new Date(time);

        ProductEntity productEntity = productEntityBuilder(level1, level2, level3, productType,
                reservationType, title, price, length, width, heigh, unit, low,
                privilege);

        MultipartFile mainPic = multipartRequest.getFile("main_pic");
        String mainPicUrl = ossService.savePicAndGetUrl(mainPic.getInputStream(), BUCKET_NAME, mainPic.getName() + timeStr);

        productEntity.setProductIconUrl(mainPicUrl);
        int test = productService.insert(productEntity);
        int id = productEntity.getId();
        if (test >= 1) {

            String productNumber = productService.productNumberBuilder(
                    Integer.parseInt(level1), Integer.parseInt(level2),
                    Integer.parseInt(level3), id
            );
            productService.updateProductId(productNumber, id);

            MultipartFile pic1 = multipartRequest.getFile("pic1");
            int pic1Result = pinInsert(pic1, id, timeStr, 1);
            MultipartFile pic2 = multipartRequest.getFile("pic2");
            int pic2Result = pinInsert(pic2, id, timeStr, 0);
            MultipartFile pic3 = multipartRequest.getFile("pic3");
            int pic3Result = pinInsert(pic3, id, timeStr, 0);
            MultipartFile pic4 = multipartRequest.getFile("pic4");
            int pic4Result = pinInsert(pic4, id, timeStr, 0);
            MultipartFile pic5 = multipartRequest.getFile("pic5");
            int pic5Result = pinInsert(pic5, id, timeStr, 0);
            MultipartFile pic6 = multipartRequest.getFile("pic6");
            int pic6Result = pinInsert(pic6, id, timeStr, 0);
            MultipartFile pic7 = multipartRequest.getFile("pic7");
            int pic7Result = pinInsert(pic7, id, timeStr, 0);
            MultipartFile pic8 = multipartRequest.getFile("pic8");
            int pic8Result = pinInsert(pic8, id, timeStr, 0);
            MultipartFile pic9 = multipartRequest.getFile("pic9");
            int pic9Result = pinInsert(pic9, id, timeStr, 0);
            MultipartFile pic10 = multipartRequest.getFile("pic10");
            int pic10Result = pinInsert(pic10, id, timeStr, 0);

            ProductPriceEntity productPriceEntity = new ProductPriceEntity();
            productPriceEntity.setPrice(Double.parseDouble(price));
            productPriceEntity.setProductId(id);
            productPriceEntity.setEnableDate(TimeUtil.parse(beginTime, "yyyy-MM-dd HH:mm:ss"));
            productPriceService.insert(productPriceEntity);

            modelMap.put("result", true);
            modelMap.put("msg", "图片状态" + pic1Result + " " + pic2Result + "" +
                    pic3Result + " " + pic4Result + " " + pic5Result + " " + pic6Result + " " +
                    pic7Result + "" + pic8Result + "" + pic9Result + "" + pic10Result);
            return modelMap;
        }

        modelMap.put("result", false);
        modelMap.put("msg", "数据库插入错误");
        return modelMap;
    }

    private int pinInsert(MultipartFile pic, int id, String timeStr, int cover) throws IOException {
        String pic1Url = ossService.savePicAndGetUrl(pic.getInputStream(), BUCKET_NAME, pic + timeStr);
        return productPictureService.insert(pictureEntityBuilder(pic1Url, cover, id));
    }


    private ProductEntity productEntityBuilder(String level1,
                                               String level2,
                                               String level3,
                                               String productType,
                                               String reservationType,
                                               String title,
                                               String price,
                                               String length,
                                               String width,
                                               String heigh,
                                               String unit,
                                               String low,
                                               String privilege) {
        ProductEntity productEntity = new ProductEntity();

        //类目
        productEntity.setCategoryCodeOne(level1);
        productEntity.setCategoryCodetTwo(level2);
        productEntity.setCategoryCodeThree(level3);
        //商品类型
        productEntity.setIsSpot(Integer.parseInt(productType));
        productEntity.setReservation(reservationType);
        productEntity.setUnit(unit);
        //商品标题
        productEntity.setProductName(title);
        //商品体积
        productEntity.setLength(Integer.parseInt(length));
        productEntity.setWidth(Integer.parseInt(width));
        productEntity.setHigh(Integer.parseInt(heigh));
        //低库存预警
        productEntity.setAlertNumber(Integer.parseInt(low));
        //商品权重
        productEntity.setWeight(Integer.parseInt(privilege));

        return productEntity;
    }

    private ProductPictureEntity pictureEntityBuilder(String url, int cover, int id) {
        ProductPictureEntity productPictureEntity = new ProductPictureEntity();
        productPictureEntity.setProductPictureUrl(url);
        productPictureEntity.setCoverPicture(cover);
        productPictureEntity.setProduct_id(id);
        return productPictureEntity;
    }
}
