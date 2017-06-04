package com.pony_admin.BusinessOutletAndWarehouse.controller;

import com.pony_admin.AdvertisementAndSpecial.entity.Advertisement;
import com.pony_admin.AdvertisementAndSpecial.entity.QueryBean.AdvertisementQueryBean;
import com.pony_admin.AdvertisementAndSpecial.service.AdvertisementService;
import com.pony_admin.BusinessOutletAndWarehouse.entity.District;
import com.pony_admin.BusinessOutletAndWarehouse.entity.QueryBean.DistrictQueryBean;
import com.pony_admin.BusinessOutletAndWarehouse.entity.QueryBean.WarehouseQueryBean;
import com.pony_admin.BusinessOutletAndWarehouse.entity.Warehouse;
import com.pony_admin.BusinessOutletAndWarehouse.service.WarehouseService;
import com.pony_admin.Product.entity.ProductEntity;
import com.pony_admin.Product.service.ProductService;
import com.pony_admin.service.Impl.OSSService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 广告Controller
 * Created by zhangmingyue on 2017/3/1 0001.
 */
@Controller
@RequestMapping(value = "/warehouse")
public class WarehouseController {

    private static final Logger log = LoggerFactory.getLogger(WarehouseController.class);
    private static final String BUCKET_NAME = "pony-custom";
    @Autowired
    private WarehouseService warehouseService;

    /**
     * 添加仓库页面访问方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/warehouseAddPage", method = RequestMethod.GET)
    public ModelAndView warehouseAddPage() {
        ModelAndView mav = new ModelAndView("/warehouseAdd");
        List<District> districtList = warehouseService.getDistrictList(new DistrictQueryBean());
        mav.addObject("districtList", districtList);
        return mav;

    }

    /**
     * 添加仓库方法
     *
     * @param warehouse
     * @return ModelAndView
     */

    @RequestMapping(value = "/warehouseAdd", method = RequestMethod.GET)
    public ModelAndView warehouseAdd(Warehouse warehouse ) {
        warehouseService.addWarehouse(warehouse);
        warehouse = warehouseService.getWarehouseByWarehouseId(warehouse.getId());
        ModelAndView mav = new ModelAndView("/warehouseEdit");
        List<District> districtList = warehouseService.getDistrictList(new DistrictQueryBean());
        mav.addObject("districtList", districtList);
        mav.addObject("warehouse", warehouse);
        return mav;

    }
    /**
     * 修改仓库页面跳转方法
     *
     * @param warehouse
     * @return ModelAndView
     */
    @RequestMapping(value = "/warehouseEditPage", method = RequestMethod.GET)
    public ModelAndView warehouseEditPage(Warehouse warehouse) {

        warehouse = warehouseService.getWarehouseByWarehouseId(warehouse.getId());

        ModelAndView mav = new ModelAndView("/warehouseEdit");
        List<District> districtList = warehouseService.getDistrictList(new DistrictQueryBean());
        mav.addObject("districtList", districtList);
        mav.addObject("warehouse", warehouse);
        return mav;

    }
    /**
     * 修改仓库方法
     *
     * @param warehouse
     * @return ModelAndView
     */
    @RequestMapping(value = "/warehouseEdit", method = RequestMethod.POST)
    public ModelAndView warehouseEdit(Warehouse warehouse) {
        ModelAndView mav = new ModelAndView("/warehouseEdit");
        warehouseService.updateWarehouse(warehouse);
        warehouse=warehouseService.getWarehouseByWarehouseId(warehouse.getId());
        District district = warehouseService.getDistrictByDistrictId(warehouse.getDistrictId());
        List<District> districtList = warehouseService.getDistrictList(new DistrictQueryBean());
        mav.addObject("districtList", districtList);
        mav.addObject("district", district);
        mav.addObject("warehouse", warehouse);
        return mav;

    }


    /**
     * 查询仓库列表页面跳转方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/warehouseListPage", method = RequestMethod.GET)
    public ModelAndView warehouseListPage(WarehouseQueryBean warehouseQueryBean) {
        ModelAndView mav = new ModelAndView("/warehouseList");
        List<Warehouse> warehouseList;
        warehouseList = warehouseService.getWarehouseList(warehouseQueryBean);
        if(warehouseList == null){
            warehouseList = new ArrayList<Warehouse>();
        }
        List<District> districtList = warehouseService.getDistrictList(new DistrictQueryBean());
        mav.addObject("districtList", districtList);
        mav.addObject("warehouseList", warehouseList);
        mav.addObject("warehouseQueryBean", warehouseQueryBean);

        return mav;

    }

    /**
     * 查询仓库列表方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/warehouseList", method = RequestMethod.GET)
    public ModelAndView warehouseList(WarehouseQueryBean warehouseQueryBean) {
        ModelAndView mav = new ModelAndView("/warehouseList");
        List<Warehouse> warehouseList;
        warehouseList = warehouseService.getWarehouseList(warehouseQueryBean);
        if(warehouseList == null){
            warehouseList = new ArrayList<Warehouse>();
        }
        List<District> districtList = warehouseService.getDistrictList(new DistrictQueryBean());
        mav.addObject("districtList", districtList);
        mav.addObject("warehouseList", warehouseList);
        mav.addObject("warehouseQueryBean", warehouseQueryBean);

        return mav;

    }
    /**
     * 添加地区页面访问方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/districtAddPage", method = RequestMethod.GET)
    public ModelAndView districtAddPage() {
        ModelAndView mav = new ModelAndView("/districtAdd");

        return mav;

    }

    /**
     * 添加地区方法
     *
     * @param district
     * @return ModelAndView
     */

    @RequestMapping(value = "/districtAdd", method = RequestMethod.GET)
    public ModelAndView districtAdd(District district) {
        warehouseService.addDistrict(district);
        district = warehouseService.getDistrictByDistrictId(district.getId());
        ModelAndView mav = new ModelAndView("/districtEdit");
        mav.addObject("district", district);
        return mav;

    }
    /**
     * 修改地区页面跳转方法
     *
     * @param district
     * @return ModelAndView
     */
    @RequestMapping(value = "/districtEditPage", method = RequestMethod.GET)
    public ModelAndView districtEditPage(District district) {
        district = warehouseService.getDistrictByDistrictId(district.getId());

        ModelAndView mav = new ModelAndView("/districtEdit");
        mav.addObject("district", district);
        return mav;

    }
    /**
     * 修改地区方法
     *
     * @param district
     * @return ModelAndView
     */
    @RequestMapping(value = "/districtEdit", method = RequestMethod.POST)
    public ModelAndView districtEdit(District district) {
        warehouseService.updateDistrict(district);
        district = warehouseService.getDistrictByDistrictId(district.getId());

        ModelAndView mav = new ModelAndView("/districtEdit");
        mav.addObject("district", district);
        return mav;

    }





//    /**
//     * 查询地区列表页面跳转方法
//     *
//     * @param
//     * @return ModelAndView
//     */
//    @RequestMapping(value = "/advertisementList", method = RequestMethod.GET)
//    public ModelAndView advertisementList() {
//        ModelAndView mav = new ModelAndView("/advertisementList");
//        List<Advertisement> advertisementList = new ArrayList<Advertisement>();
////        Advertisement ad;
////        for(int i=0;i<100; i++){
////            ad = new Advertisement();
////            ad.setAdvertisementName("广告"+i);
////            ad.setBeginTime(new Date());
////            ad.setEndTime(new Date());
////            advertisementList.add(ad);
////        }
//        mav.addObject("advertisementList", advertisementList);
////        advertisementQueryBean = new AdvertisementQueryBean();
//        mav.addObject("advertisementQueryBean", advertisementQueryBean);
////        advertisementQueryBean
//        return mav;
//
//    }

    /**
     * 查询地区列表方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/districtList", method = RequestMethod.GET)
    public ModelAndView districtList(DistrictQueryBean districtQueryBean) {
        if(districtQueryBean == null){
            districtQueryBean = new DistrictQueryBean();
        }

        ModelAndView mav = new ModelAndView("/districtList");
        List<District> districtList = warehouseService.getDistrictList(districtQueryBean);
        mav.addObject("districtList", districtList);

        return mav;

    }

}
