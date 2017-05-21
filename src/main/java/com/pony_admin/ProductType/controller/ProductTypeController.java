package com.pony_admin.ProductType.controller;


import com.pony_admin.Product.entity.ProductEntity;
import com.pony_admin.ProductType.entity.ProductType;
import com.pony_admin.ProductType.entity.ProductTypeQueryBean;
import com.pony_admin.ProductType.service.ProductTypeService;
import com.pony_admin.domain.CategoryEntity;
import com.pony_admin.service.Impl.OSSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品类别Controller
 * Created by zhangmingyue on 2017/3/1 0001.
 */
@Controller
@RequestMapping(value = "/ProductType")
public class ProductTypeController {

    private static final Logger log = LoggerFactory.getLogger(ProductTypeController.class);
    private static final String BUCKET_NAME = "pony-custom";

    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private OSSService ossService;

    private ProductType productType = new ProductType();


    /**
     * 产品分类列表页面跳转方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/toProductTypeListPage", method = RequestMethod.GET)
    public ModelAndView toProductTypeListPage() {
        ModelAndView mav = new ModelAndView("/productTypeList");
        ProductTypeQueryBean productTypeQueryBean = new ProductTypeQueryBean();
        mav.addObject("productTypeQueryBean", productTypeQueryBean);
        return mav;

    }
    /**
     * 产品分类列表查询方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/productTypeList", method = RequestMethod.GET)
    public ModelAndView productTypeList(ProductTypeQueryBean productTypeQueryBean) {
        ModelAndView mav = new ModelAndView("/productTypeList");
        List<ProductType> productTypeList = productTypeService.getProductTypeListByQuerybean(productTypeQueryBean);
        mav.addObject("productTypeQueryBean", productTypeQueryBean);
        mav.addObject("productTypeList", productTypeList);
        return mav;

    }
    /**
     * 产品分类修改页面跳转方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/toProductTypeEdit", method = RequestMethod.GET)
    public ModelAndView toProductTypeEdit(ProductType productType) {
        return initializeEditPageMassage(productType.getId());

    }
    /**
     * 修改产品类别方法
     *
     * @param productType
     * @return ModelAndView
     */
    @RequestMapping(value = "/updateProductType", method = RequestMethod.POST)
    public ModelAndView updateProductType(ProductType productType, HttpServletRequest request) {
        //从request中获取文件
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile picTemp = multipartRequest.getFile("picTemp");
        if(picTemp!=null) {
            //获取时间戳
            long time = System.currentTimeMillis();
            String timeStr = String.valueOf(time);
            String productTypeIconUrl = null;
            //向阿里云存储中上传图片并获得url
            try {
                productTypeIconUrl = ossService.savePicAndGetUrl(picTemp.getInputStream(), BUCKET_NAME, picTemp + timeStr);
            } catch (IOException e) {
                e.printStackTrace();
            }
            productType.setProductTypeIconUrl(productTypeIconUrl);
        }

        productTypeService.updateProductType(productType);
        return initializeEditPageMassage(productType.getId());

    }

    /**
     * 产品分类添加页面跳转方法
     *
     *
     * @return ModelAndView
     */
    @RequestMapping(value = "/toProductTypeAddPage", method = RequestMethod.GET)
    public ModelAndView toProductTypeAddPage() {

        List<ProductType> typeLevelOneList = productTypeService.getChildProductTypeListByProductTypeId(0);
        ModelAndView mav = new ModelAndView("/productTypeAdd");
        mav.addObject("typeLevelOneList", typeLevelOneList);
        return mav;

    }
    /**
     * 添加产品分类
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/addProductType", method = RequestMethod.POST)
    public ModelAndView addProductType(ProductType productType, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/productTypeAdd");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile productTypeIcon = multipartRequest.getFile("productTypeIcon");
        if(productTypeIcon!=null) {
            //获取时间戳
            long time = System.currentTimeMillis();
            String timeStr = String.valueOf(time);
            String productTypeIconUrl = null;
            //向阿里云存储中上传图片并获得url
            try {
                productTypeIconUrl = ossService.savePicAndGetUrl(productTypeIcon.getInputStream(), BUCKET_NAME, productTypeIcon + timeStr);
            } catch (IOException e) {
                e.printStackTrace();
            }
            productType.setProductTypeIconUrl(productTypeIconUrl);
        }
        productTypeService.insertProductType(productType);

        return initializeEditPageMassage(productType.getId());

    }





    /**
     * 添加产品
     *
     * @param productTypeId
     * @return int
     */
    @RequestMapping(value = "/addProductToProductType", method = RequestMethod.GET)
    public ModelAndView addProductToProductType(int productTypeId,int productId){
        productTypeService.addProductToProductType(productTypeId,productId);
        return initializeEditPageMassage(productTypeId);
    }
    /**
     * 删除产品
     *
     * @param productTypeId
     * @return int
     */
    @RequestMapping(value = "/deleteProductToProductType", method = RequestMethod.GET)
    public ModelAndView deleteProductToProductType(int productTypeId,int productId){
        productTypeService.deleteProductToProductType(productTypeId,productId);
        return initializeEditPageMassage(productTypeId);
    }

    @RequestMapping(value = "/getProductTypeByParentId/{id}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> getProductTypeByParentId(@PathVariable int id) throws Exception {
        log.info("id={}", id);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (id < 0) {
            modelMap.put("result", false);
            return modelMap;
        }

        List<ProductType> list = productTypeService.getChildProductTypeListByProductTypeId(id);
        log.info("list={}", list);
        modelMap.put("orgModelList", list);
        return modelMap;
    }

    private ModelAndView initializeEditPageMassage(int productTypeId){
        ModelAndView mav;
        productType = productTypeService.getProductTypeByProductTypeId(productTypeId);
        if(productType.getTypeLevel()==3) {
            mav = new ModelAndView("/ProductTypeEditB");
            List<ProductEntity> productEntityList = productTypeService.getProductEntityListByProductTypeId(productType.getId());
            mav.addObject("productType", productType);
            mav.addObject("productEntityList", productEntityList);
        }else{
            mav = new ModelAndView("/ProductTypeEditA");
            mav.addObject("productType", productType);
        }
        return mav;
    }
}
