package com.pony_admin.Product.controller;

import com.pony_admin.Product.entity.ProductEntity;
import com.pony_admin.Product.entity.ProductPictureEntity;
import com.pony_admin.Product.entity.ProductPriceEntity;
import com.pony_admin.Product.entity.ProductPromotionEntity;
import com.pony_admin.Product.entity.querybean.ProductQueryBean;
import com.pony_admin.Product.service.ProductService;
import com.pony_admin.Product.service.ProductPictureService;
import com.pony_admin.Product.service.ProductPriceService;
import com.pony_admin.domain.CategoryEntity;
import com.pony_admin.domain.ReservationEntity;
import com.pony_admin.enumeration.CategoryType;
import com.pony_admin.service.*;
import com.pony_admin.service.Impl.OSSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 产品controller
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private static final String BUCKET_NAME = "pony-custom";
    private static final String pattern = "yyyy-MM-dd HH:mm:ss";
    private ProductQueryBean productQueryBean = new ProductQueryBean();
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



    private List<CategoryEntity> categoryOneEntityList;
    private List<CategoryEntity> categoryTwoEntityList ;
    private List<CategoryEntity> categoryThreeEntityList;
    private CategoryEntity categoryEntityOne;
    private CategoryEntity categoryEntityTwo;
    private CategoryEntity categoryEntityThree;
    private List<ReservationEntity> reservationEntityList;
    private ReservationEntity myReservationEntity;
    private ProductEntity productEntity;
    private List<ProductPictureEntity> productPictureEntityList;
    private List<ProductPriceEntity> productPriceEntityList;
    /**
     * 查询产品列表页面跳转方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    public ModelAndView productList() {
        ModelAndView mav = new ModelAndView("/productList");
        List<CategoryEntity> categoryEntityList = categoryService.getCategoryByType(CategoryType.level1);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();

        mav.addObject("productList", productList);

        productQueryBean.setProductNumber("");
        productQueryBean.setCategoryCodeOne("");
        productQueryBean.setCategoryCodeTwo("");
        productQueryBean.setCategoryCodeThree("");
        mav.addObject("productQueryBean", productQueryBean);
        mav.addObject("categoryEntityList", categoryEntityList);

        return mav;

    }
    /**
     * 查询产品列表方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/getProductList", method = RequestMethod.GET)
    public ModelAndView getProductList(ProductQueryBean productQueryBean) {
        List<CategoryEntity> categoryEntityList = categoryService.getCategoryByType(CategoryType.level1);
        ModelAndView mav = new ModelAndView("/productList");
        List<ProductEntity> productList = productService.getProductListByQuerybean(productQueryBean);
        mav.addObject("productList", productList);
        mav.addObject("productQueryBean", productQueryBean);
        mav.addObject("categoryEntityList", categoryEntityList);
        return mav;

    }

    /**
     * 产品添加页面跳转方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/toProductInsertPage", method = RequestMethod.GET)
    public ModelAndView toProductInsertPage(){
        ModelAndView mav = new ModelAndView("/productInsert");
        List<CategoryEntity> categoryEntityList = categoryService.getCategoryByType(CategoryType.level1);
        List<ReservationEntity> reservationEntityList = reservationService.getAllReservationName();
        mav.addObject("categoryEntityList", categoryEntityList);
        mav.addObject("reservationEntityList", reservationEntityList);
        return mav;

    }
    /**
     * 产品添加方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/productInsert", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView productInsert(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/productEdit");

        ProductEntity productEntity = productEntityBuilder(request);
        int test = productService.insert(productEntity);
        if (test >= 1) {

            String productNumber = productService.productNumberBuilder(
                    Integer.parseInt(productEntity.getCategoryCodeOne()), Integer.parseInt(productEntity.getCategoryCodeTwo()),
                    Integer.parseInt(productEntity.getCategoryCodeThree()), productEntity.getId()
            );

            productService.updateProductId(productNumber, productEntity.getId());
            mav = initializeEditPageMessage(productEntity.getId(),mav);

            return mav;
        }

        mav = initializeEditPageMessage(productEntity.getId(),mav);

        return mav;
    }



    /**
     * 产品修改页面跳转方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/toProductEdit", method = RequestMethod.GET)
    public ModelAndView toProductEdit(ProductEntity productEntity){
        ModelAndView mav = new ModelAndView("/productEdit");
        mav = initializeEditPageMessage(productEntity.getId(),mav);

        return mav;

    }
    /**
     * 产品修改方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/productEdit", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView productEdit(ProductEntity productEntity,@RequestParam("newProductIcon") MultipartFile newProductIconFile){
        ModelAndView mav = new ModelAndView("/productEdit");
        ProductEntity productEntityOld = productService.getProductByProductId(productEntity.getId());
        if(productEntity.getReservationId()!=productEntityOld.getReservationId()){
            ReservationEntity reservationEntity = reservationService.getReservationEntityById(productEntity.getReservationId());
            productEntity.setReservationPicUrl(reservationEntity.getUrl());
            productEntity.setReservationPicWidth(reservationEntity.getReservationPicWidth());
            productEntity.setReservationPicHeight(reservationEntity.getReservationPicHeight());
        }
        if(!newProductIconFile.getOriginalFilename().equals("")) {
            long time = System.currentTimeMillis();
            String timeStr = String.valueOf(time);
            String newProductIconUrl = "";
            try {
                newProductIconUrl = ossService.savePicAndGetUrl(newProductIconFile.getInputStream(), BUCKET_NAME, timeStr + newProductIconFile.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
            productEntity.setProductIconUrl(newProductIconUrl);
        }
        int test = productService.updateProduct(productEntity);
        mav = initializeEditPageMessage(productEntity.getId(),mav);

        return mav;
    }


    /**
     * 产品价格添加方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/productPriceAdd", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView productPriceAdd(double price,int productId,String enableDate){
        ProductPriceEntity productPriceEntity = new ProductPriceEntity();
        productPriceEntity.setPrice(price);
        productPriceEntity.setProductId(productId);
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTrans = null;
        try {
            dateTrans = format1.parse(enableDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        productPriceEntity.setEnableDate(dateTrans);

        ModelAndView mav = new ModelAndView("/productEdit");
        int test = productPriceService.insert(productPriceEntity);
        mav = initializeEditPageMessage(productId,mav);

        return mav;
    }
    /**
     * 产品价格删除方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/productPriceDelete", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView productPriceDelete(int productPriceId,int productId){

        ModelAndView mav = new ModelAndView("/productEdit");
        int test = productPriceService.deleteProductPriceById(productPriceId);
        mav = initializeEditPageMessage(productId,mav);

        return mav;
    }

    /**
     * 产品促销添加方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/productPromotionEdit", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView productPromotionEdit(ProductEntity productEntity){
        ModelAndView mav = new ModelAndView("/productEdit");
        productEntity.setPromotionNumberOriginal(productEntity.getPromotionNumber());
        int test = productService.updateProductPromotion(productEntity);
        mav = initializeEditPageMessage(productEntity.getId(),mav);
        return mav;
    }
    /**
     * 产品图片添加方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/productPictureAdd", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView productPictureAdd(HttpServletRequest request){
        String productId = request.getParameter("productId");
        String isCover = request.getParameter("coverpicture");

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile productPicture = multipartRequest.getFile("productPicture");
        long time = System.currentTimeMillis();
        String timeStr = String.valueOf(time);
        String pic1Url = "";
        try {
            pic1Url = ossService.savePicAndGetUrl(productPicture.getInputStream(), BUCKET_NAME,  timeStr+productPicture.getOriginalFilename());
        }catch (Exception e){
            e.printStackTrace();
        }
        productPictureService.insert(pictureEntityBuilder(pic1Url, new Integer(isCover), new Integer(productId)));
        ModelAndView mav = new ModelAndView("/productEdit");

        mav = initializeEditPageMessage(new Integer(productId),mav);

        return mav;
    }

    /**
     * 产品图片删除方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/productPictureDelete", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView productPictureDelete(int productId,int productPictureId){
        ModelAndView mav = new ModelAndView("/productEdit");
        int test = productPictureService.deleteProductPictureById(productPictureId);

        mav = initializeEditPageMessage(productId,mav);

        return mav;
    }

    private ProductEntity productEntityBuilder(HttpServletRequest request) {
        String productName = request.getParameter("productName");
        String weightStr = request.getParameter("weight");
        String productLengthStr = request.getParameter("productLength");
        String productHighStr = request.getParameter("productHigh");
        String productWidthStr = request.getParameter("productWidth");
        String reservationIdStr = request.getParameter("reservationId");
        String categoryCodeOne = request.getParameter("categoryCodeOne");
        String categoryCodeTwo = request.getParameter("categoryCodeTwo");
        String categoryCodeThree = request.getParameter("categoryCodeThree");
        String unit = request.getParameter("unit");
        String alertNumberStr = request.getParameter("alertNumber");


        ReservationEntity reservationEntity = reservationService.getReservationEntityById(new Integer(reservationIdStr));

        ProductEntity productEntity = new ProductEntity();
        String productIconUrl= "";
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile productIcon = multipartRequest.getFile("productIcon");
        long time = System.currentTimeMillis();
        String timeStr = String.valueOf(time);
        try {
            productIconUrl = ossService.savePicAndGetUrl(productIcon.getInputStream(), BUCKET_NAME, timeStr+productIcon.getOriginalFilename() );
//            String mainPicUrl = ossService.savePicAndGetUrl(mainPic.getInputStream(),
//                    BUCKET_NAME, String.valueOf(time)+mainPic.getOriginalFilename());
        }catch (Exception e){
            e.printStackTrace();
        }
        productEntity.setProductIconUrl(productIconUrl);
        //类目
        productEntity.setCategoryCodeOne(categoryCodeOne);
        productEntity.setCategoryCodeTwo(categoryCodeTwo);
        productEntity.setCategoryCodeThree(categoryCodeThree);
        productEntity.setReservationId(reservationEntity.getId());
        productEntity.setReservationPicUrl(reservationEntity.getUrl());
        productEntity.setReservationPicHeight(reservationEntity.getReservationPicHeight());
        productEntity.setReservationPicWidth(reservationEntity.getReservationPicWidth());
        productEntity.setUnit(unit);
        productEntity.setWeight(Integer.parseInt(weightStr));
        productEntity.setAlertNumber(Integer.parseInt(alertNumberStr));
        productEntity.setProductHigh(Integer.parseInt(productHighStr));
        productEntity.setProductLength(Integer.parseInt(productLengthStr));
        productEntity.setProductName(productName);
        productEntity.setProductWidth(Integer.parseInt(productWidthStr));

        return productEntity;
    }
    private ModelAndView initializeEditPageMessage(int productId,ModelAndView mav){
        productEntity = productService.getProductByProductId(productId);
        categoryOneEntityList= categoryService.getCategoryByType(CategoryType.level1);
        categoryTwoEntityList = categoryService.getCategoryByParent(productEntity.getCategoryCodeOne());
        categoryThreeEntityList = categoryService.getCategoryByParent(productEntity.getCategoryCodeTwo());
        reservationEntityList = reservationService.getAllReservationName();
        for(CategoryEntity categoryEntity:categoryOneEntityList){
            if(categoryEntity.getId()== new Integer(productEntity.getCategoryCodeOne())){
                categoryEntityOne = categoryEntity;
            }
        }
        for(CategoryEntity categoryEntity:categoryTwoEntityList){
            if(categoryEntity.getId() == new Integer(productEntity.getCategoryCodeTwo())){
                categoryEntityTwo = categoryEntity;
            }
        }

        for(CategoryEntity categoryEntity:categoryThreeEntityList){
            if(categoryEntity.getId() == new Integer(productEntity.getCategoryCodeThree())){
                categoryEntityThree = categoryEntity;
            }
        }
        for(ReservationEntity reservationEntity:reservationEntityList){
            if(reservationEntity.getId() == productEntity.getReservationId()){
                myReservationEntity = reservationEntity;
            }
        }
        productPictureEntityList = productPictureService.getProductPictureEntityListByProductId(productEntity.getId());
        productPriceEntityList = productPriceService.getProductPriceEntityListByProductId(productEntity.getId());
        mav.addObject("categoryOneEntityList", categoryOneEntityList);
        mav.addObject("categoryTwoEntityList", categoryTwoEntityList);
        mav.addObject("categoryThreeEntityList", categoryThreeEntityList);
        mav.addObject("categoryEntityOne", categoryEntityOne);
        mav.addObject("categoryEntityTwo", categoryEntityTwo);
        mav.addObject("categoryEntityThree", categoryEntityThree);
        mav.addObject("reservationEntityList", reservationEntityList);
        mav.addObject("myReservationEntity", myReservationEntity);
        mav.addObject("productEntity", productEntity);
        mav.addObject("productPictureEntityList", productPictureEntityList);
        mav.addObject("productPriceEntityList", productPriceEntityList);
        return mav;
    }
    private ProductPictureEntity pictureEntityBuilder(String url, int cover, int id) {
        ProductPictureEntity productPictureEntity = new ProductPictureEntity();
        productPictureEntity.setProductPictureUrl(url);
        productPictureEntity.setCoverpicture(cover);
        productPictureEntity.setProduct_id(id);
        return productPictureEntity;
    }
    @ModelAttribute("producttQueryBean")
    public ProductQueryBean getProductQueryBean(){

        return productQueryBean;

    }
}
