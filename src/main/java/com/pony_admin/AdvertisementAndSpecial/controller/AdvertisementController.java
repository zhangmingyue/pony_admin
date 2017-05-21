package com.pony_admin.AdvertisementAndSpecial.controller;

import com.pony_admin.AdvertisementAndSpecial.entity.Advertisement;
import com.pony_admin.AdvertisementAndSpecial.entity.QueryBean.AdvertisementQueryBean;
import com.pony_admin.AdvertisementAndSpecial.service.AdvertisementService;
import com.pony_admin.Product.entity.ProductEntity;
import com.pony_admin.service.Impl.OSSService;
import com.pony_admin.Product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * 广告Controller
 * Created by zhangmingyue on 2017/3/1 0001.
 */
@Controller
@RequestMapping(value = "/Advertisement")
public class AdvertisementController {

    private static final Logger log = LoggerFactory.getLogger(AdvertisementController.class);
    private static final String BUCKET_NAME = "pony-custom";
    @Autowired
    private AdvertisementService advertisementService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OSSService ossService;

    private Advertisement advertisement = new Advertisement();
    private AdvertisementQueryBean advertisementQueryBean = new AdvertisementQueryBean();


    /**
     * 添加广告方法
     *
     * @param advertisement
     * @return ModelAndView
     */

    @RequestMapping(value = "/addAdvertisement", method = RequestMethod.GET)
    public ModelAndView addAdvertisement(Advertisement advertisement, HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile advertisementPicture = multipartRequest.getFile("advertisementPicture");
        String advertisementPictureUrl = "";

        long time = System.currentTimeMillis();
        String timeStr = String.valueOf(time);

        try {
            advertisementPictureUrl = ossService.savePicAndGetUrl(advertisementPicture.getInputStream(), BUCKET_NAME, timeStr + advertisementPicture.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }

        advertisement.setAdvertisementPictureUrl(advertisementPictureUrl);
        int test = advertisementService.addAdvertisement(advertisement);
        ProductEntity productEntity = productService.getProductByProductId(advertisement.getProductId());
        if(productEntity == null){
            productEntity = new ProductEntity();
            productEntity.setProductNumber("");
        }
        advertisement.setProductEntity(productEntity);
        ModelAndView mav = new ModelAndView("/editAdvertisementPage");
        mav.addObject("advertisement", advertisement);
        return mav;

    }

    /**
     * 修改广告方法
     *
     * @param advertisement
     * @return ModelAndView
     */
    @RequestMapping(value = "/updateAdvertisement", method = RequestMethod.POST)
    public ModelAndView updateAdvertisement(Advertisement advertisement, HttpServletRequest request) {
        //从request中获取文件
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile picTemp = multipartRequest.getFile("picTemp");
        String advertisementPictureUrl = "";
        if(!picTemp.getOriginalFilename().equals("")) {
            long time = System.currentTimeMillis();
            String timeStr = String.valueOf(time);

            try {
                advertisementPictureUrl = ossService.savePicAndGetUrl(picTemp.getInputStream(), BUCKET_NAME, timeStr + picTemp.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
            advertisement.setAdvertisementPictureUrl(advertisementPictureUrl);
        }

        advertisementService.updateAdvertisement(advertisement);
        ProductEntity productEntity = productService.getProductByProductId(advertisement.getProductId());
        if(productEntity == null){
            productEntity = new ProductEntity();
            productEntity.setProductNumber("  ");
        }
        advertisement.setProductEntity(productEntity);

        ModelAndView mav = new ModelAndView("/editAdvertisementPage");
        mav.addObject("advertisement", advertisement);
        return mav;

    }

    /**
     * 修改广告页面跳转方法
     *
     * @param advertismentQueryBean
     * @return ModelAndView
     */
    @RequestMapping(value = "/toEditAdvertisementPage", method = RequestMethod.GET)
    public ModelAndView updateAdvertisement(AdvertisementQueryBean advertismentQueryBean) {

        advertisement = advertisementService.getAdvertisementByAdvertisementId(advertismentQueryBean);
        ProductEntity productEntity = productService.getProductByProductId(advertisement.getProductId());

        if(productEntity == null){
            productEntity = new ProductEntity();
            productEntity.setProductNumber("");
        }
        advertisement.setProductEntity(productEntity);
        ModelAndView mav = new ModelAndView("/editAdvertisementPage");
        mav.addObject("advertisement", advertisement);
        return mav;

    }

    /**
     * 添加广告页面访问方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/addAdvertisementPage", method = RequestMethod.GET)
    public ModelAndView addAdvertisementPage() {
        ModelAndView mav = new ModelAndView("/addAdvertisementPage");

        mav.addObject("advertisement", advertisement);
        return mav;

    }

    /**
     * 查询广告列表页面跳转方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/advertisementList", method = RequestMethod.GET)
    public ModelAndView advertisementList() {
        ModelAndView mav = new ModelAndView("/advertisementList");
        List<Advertisement> advertisementList = new ArrayList<Advertisement>();
//        Advertisement ad;
//        for(int i=0;i<100; i++){
//            ad = new Advertisement();
//            ad.setAdvertisementName("广告"+i);
//            ad.setBeginTime(new Date());
//            ad.setEndTime(new Date());
//            advertisementList.add(ad);
//        }
        mav.addObject("advertisementList", advertisementList);
//        advertisementQueryBean = new AdvertisementQueryBean();
        mav.addObject("advertisementQueryBean", advertisementQueryBean);
//        advertisementQueryBean
        return mav;

    }

    /**
     * 查询广告列表方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/getAdvertisementList", method = RequestMethod.GET)
    public ModelAndView getAdvertisementList(AdvertisementQueryBean advertisementQueryBean) {
        if(advertisementQueryBean == null){
            advertisementQueryBean = new AdvertisementQueryBean();
        }
        ModelAndView mav = new ModelAndView("/advertisementList");
        List<Advertisement> advertisementList = advertisementService.getAdvertisementList(advertisementQueryBean);
        mav.addObject("advertisementList", advertisementList);
        mav.addObject("advertisementQueryBean", advertisementQueryBean);
        return mav;

    }

    /**
     * 验证产品号并获取产品ID AJAX方法
     *
     * @param productEntity
     * @return ModelAndView
     */
    @RequestMapping(value = "/checkProductNumber", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkProductNumber(ProductEntity productEntity){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        productEntity = productService.getProductByProductNumber(productEntity.getProductNumber());
        modelMap.put("productEntity",productEntity);
        return modelMap;
    }

    /**
     * 广告删除方法
     *
     * @param advertisementIds
     * @return ModelAndView
     */
    private ModelAndView advertisementDelete(AdvertisementQueryBean advertisementQueryBean,int[] advertisementIds){

        if(advertisementQueryBean == null){
            advertisementQueryBean = new AdvertisementQueryBean();
        }
        ModelAndView mav = new ModelAndView("/advertisementList");
        List<Advertisement> advertisementList = advertisementService.getAdvertisementList(advertisementQueryBean);
        mav.addObject("advertisementList", advertisementList);
        mav.addObject("advertisementQueryBean", advertisementQueryBean);
        return mav;
    }

    @ModelAttribute("advertisement")
    public Advertisement getAdvertisement(){

        return advertisement;

    }
    @ModelAttribute("advertisementQueryBean")
    public AdvertisementQueryBean getAdvertisementQueryBean(){

        return advertisementQueryBean;

    }
}
