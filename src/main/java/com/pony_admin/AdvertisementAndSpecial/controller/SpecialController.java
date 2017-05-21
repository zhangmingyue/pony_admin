package com.pony_admin.AdvertisementAndSpecial.controller;

import com.pony_admin.AdvertisementAndSpecial.entity.QueryBean.SpecialQueryBean;
import com.pony_admin.AdvertisementAndSpecial.entity.Special;
import com.pony_admin.AdvertisementAndSpecial.entity.SpecialProduct;
import com.pony_admin.AdvertisementAndSpecial.entity.SpecialTextItem;
import com.pony_admin.AdvertisementAndSpecial.service.SpecialService;
import com.pony_admin.service.Impl.OSSService;
import com.pony_admin.Product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/3
 */
@Controller
@RequestMapping(value = "/Special")
public class SpecialController {

    private static final Logger log = LoggerFactory.getLogger(AdvertisementController.class);
    private static final String BUCKET_NAME = "pony-custom";
    @Autowired
    private SpecialService specialService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OSSService ossService;
    private Special special = new Special();
    private SpecialQueryBean specialQueryBean = new SpecialQueryBean();

    /**
     * 查询专题列表页面跳转方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/specialList", method = RequestMethod.GET)
    public ModelAndView specialList() {
        ModelAndView mav = new ModelAndView("/specialList");
        List<Special> specialList = new ArrayList<Special>();
//        Advertisement ad;
//        for(int i=0;i<100; i++){
//            ad = new Advertisement();
//            ad.setAdvertisementName("广告"+i);
//            ad.setBeginTime(new Date());
//            ad.setEndTime(new Date());
//            advertisementList.add(ad);
//        }
        mav.addObject("specialList", specialList);
//        advertisementQueryBean = new AdvertisementQueryBean();
        mav.addObject("specialQueryBean", specialQueryBean);
//        advertisementQueryBean
        return mav;

    }
    /**
     * 查询专题列表方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/getSpecialList", method = RequestMethod.GET)
    public ModelAndView getSpecialList(SpecialQueryBean specialQueryBean) {

        ModelAndView mav = new ModelAndView("/specialList");
        List<Special> specialList = specialService.getSpecialList(specialQueryBean);
        mav.addObject("specialList", specialList);
        mav.addObject("specialQueryBean", specialQueryBean);
        return mav;

    }
    /**
     * 专题添加页面跳转方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/toAddSpecialPage", method = RequestMethod.GET)
    public ModelAndView toAddSpecialPage() {

        ModelAndView mav = new ModelAndView("/specialInsert");

        return mav;

    }
    /**
     * 专题添加方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/addSpecial", method = RequestMethod.POST)
    public ModelAndView addSpecial(Special special,HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/editSpecial");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile coverPage = multipartRequest.getFile("coverPage");
        String coverPageUrl = pictureUpload(coverPage);
        special.setCoverPageUrl(coverPageUrl);
        special.setSpecialPictureUrl(coverPageUrl);
        specialService.addSpecial(special);
        SpecialQueryBean specialQueryBean = new SpecialQueryBean();
        specialQueryBean.setSpecialId(special.getId());
        special =specialService.getSpecialBySpecialId(specialQueryBean);
        mav.addObject("special", special);
        return mav;

    }
    /**
     * 专题修改方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/editSpecial", method = RequestMethod.POST)
    public ModelAndView editSpecial(Special  special,HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/specialEdit");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile coverPage = multipartRequest.getFile("coverPage");
        special.setSpecialPictureUrl(special.getCoverPageUrl());
        if(!coverPage.getOriginalFilename().equals("")) {
            String coverPageUrl = pictureUpload(coverPage);
            special.setSpecialPictureUrl(coverPageUrl);
            special.setCoverPageUrl(coverPageUrl);
        }

        specialService.updateSpecialBySpecialId(special);
        mav = initializeEditPageMessage(special.getId(),mav);

        return mav;

    }
    /**
     * 专题修改页面跳转方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/toEditSpecialPage", method = RequestMethod.GET)
    public ModelAndView toEditSpecialPage(Special  special) {

        ModelAndView mav = new ModelAndView("/specialEdit");

        SpecialQueryBean specialQueryBean = new SpecialQueryBean();
        specialQueryBean.setSpecialId(special.getId());
        special =specialService.getSpecialBySpecialId(specialQueryBean);
        mav = initializeEditPageMessage(special.getId(),mav);

        return mav;

    }
    /**
     * 专题文本项添加方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/addSpecialTextItem", method = RequestMethod.POST)
    public ModelAndView addSpecialTextItem(SpecialTextItem specialTextItem,HttpServletRequest request) {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile itemPicture = multipartRequest.getFile("itemPicture");
        if(!itemPicture.getOriginalFilename().equals("")) {
            String itemPictureUrl = pictureUpload(itemPicture);
            specialTextItem.setItemPictureUrl(itemPictureUrl);
        }
        ModelAndView mav = new ModelAndView("/specialEdit");
        specialService.addSpecialTextItem(specialTextItem);
        mav = initializeEditPageMessage(specialTextItem.getSpecialId(),mav);
        return mav;
    }
    /**
     * 专题文本项删除方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/deleteSpecialTextItem", method = RequestMethod.GET)
    public ModelAndView deleteSpecialTextItem(int specialTextItemId,int specialId) {

        ModelAndView mav = new ModelAndView("/specialEdit");
        specialService.deleteSpecialTextItemBySpecialTextItemId(specialTextItemId);
        mav = initializeEditPageMessage(specialId,mav);
        return mav;
    }
    /**
     * 专题产品添加方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/addSpecialProduct", method = RequestMethod.POST)
    public ModelAndView addSpecialProduct(SpecialProduct specialProduct) {

        ModelAndView mav = new ModelAndView("/specialEdit");
        specialService.addSpecialProduct(specialProduct);
        mav = initializeEditPageMessage(specialProduct.getSpecialId(),mav);
        return mav;
    }
    /**
     * 专题产品删除方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/deleteSpecialProduct", method = RequestMethod.GET)
    public ModelAndView deleteSpecialProduct(SpecialProduct specialProduct) {

        ModelAndView mav = new ModelAndView("/specialEdit");
        specialService.deleteSpecialProductBySpecialAndProductId(specialProduct.getSpecialId(),specialProduct.getProductId());
        mav = initializeEditPageMessage(specialProduct.getSpecialId(),mav);
        return mav;
    }

    private String pictureUpload(MultipartFile productPicture){

        long time = System.currentTimeMillis();
        String timeStr = String.valueOf(time);
        String pic1Url = "";
        try {
            pic1Url = ossService.savePicAndGetUrl(productPicture.getInputStream(), BUCKET_NAME,  timeStr+productPicture.getOriginalFilename());
        }catch (Exception e){
            e.printStackTrace();
        }
        return pic1Url;
    }

    private ModelAndView initializeEditPageMessage(int specialId,ModelAndView mav){
        SpecialQueryBean specialQueryBean = new SpecialQueryBean();
        specialQueryBean.setSpecialId(specialId);
        special =specialService.getSpecialBySpecialId(specialQueryBean);
        mav.addObject("special", special);
        return mav;

    }
}
