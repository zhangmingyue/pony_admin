package com.pony_admin.BusinessOutletAndWarehouse.controller;

import com.pony_admin.AdvertisementAndSpecial.entity.Advertisement;
import com.pony_admin.AdvertisementAndSpecial.entity.QueryBean.AdvertisementQueryBean;
import com.pony_admin.AdvertisementAndSpecial.service.AdvertisementService;
import com.pony_admin.BusinessOutletAndWarehouse.entity.BusinessOutlet;
import com.pony_admin.BusinessOutletAndWarehouse.entity.District;
import com.pony_admin.BusinessOutletAndWarehouse.entity.QueryBean.BusinessOutletQueryBean;
import com.pony_admin.BusinessOutletAndWarehouse.entity.QueryBean.DistrictQueryBean;
import com.pony_admin.BusinessOutletAndWarehouse.entity.QueryBean.WarehouseQueryBean;
import com.pony_admin.BusinessOutletAndWarehouse.entity.Warehouse;
import com.pony_admin.BusinessOutletAndWarehouse.service.BusinessOutletService;
import com.pony_admin.BusinessOutletAndWarehouse.service.WarehouseService;
import com.pony_admin.Product.entity.ProductEntity;
import com.pony_admin.Product.service.ProductService;
import com.pony_admin.service.Impl.OSSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping(value = "/businessOutlet")
public class BusinessOutletController {

    private static final Logger log = LoggerFactory.getLogger(BusinessOutletController.class);
    private static final String BUCKET_NAME = "pony-custom";
    @Autowired
    private BusinessOutletService businessOutletService;
    @Autowired
    private WarehouseService warehouseService;

    /**
     * 添加自提点页面访问方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/businessOutletAddPage", method = RequestMethod.GET)
    public ModelAndView businessOutletAddPage() {
        ModelAndView mav = new ModelAndView("/businessOutletAdd");
        List<District> districtList = warehouseService.getDistrictList(new DistrictQueryBean());

        mav.addObject("districtList", districtList);

        return mav;

    }


    /**
     * 添加自提点方法
     *
     * @param businessOutlet
     * @return ModelAndView
     */

    @RequestMapping(value = "/businessOutletAdd", method = RequestMethod.GET)
    public ModelAndView businessOutletAdd(BusinessOutlet businessOutlet) {


        int test = businessOutletService.addBusinessOutlet(businessOutlet);
        businessOutlet = businessOutletService.getBusinessOutletByBusinessOutletId(businessOutlet.getId());
        if(businessOutlet == null){
            businessOutlet = new BusinessOutlet();

        }
        List<District> districtList = warehouseService.getDistrictList(new DistrictQueryBean());
        WarehouseQueryBean warehouseQueryBean = new WarehouseQueryBean();
        warehouseQueryBean.setDistrictId(businessOutlet.getDistrictId());
        List<Warehouse> warehouseList = warehouseService.getWarehouseList(warehouseQueryBean);
        ModelAndView mav = new ModelAndView("/businessOutletEdit");
        mav.addObject("districtList", districtList);
        mav.addObject("businessOutlet", businessOutlet);
        mav.addObject("warehouseList", warehouseList);
        return mav;

    }
    /**
     * 修改自提点页面跳转方法
     *
     * @param businessOutletId
     * @return ModelAndView
     */
    @RequestMapping(value = "/businessOutletEditPage", method = RequestMethod.GET)
    public ModelAndView businessOutletEditPage(int businessOutletId) {

        BusinessOutlet businessOutlet = businessOutletService.getBusinessOutletByBusinessOutletId(businessOutletId);
        Warehouse warehouse = warehouseService.getWarehouseByWarehouseId(businessOutlet.getWarehouseId());
        List<District> districtList = warehouseService.getDistrictList(new DistrictQueryBean());
        WarehouseQueryBean warehouseQueryBean = new WarehouseQueryBean();
        warehouseQueryBean.setDistrictId(warehouse.getDistrictId());
        List<Warehouse> warehouseList = warehouseService.getWarehouseList(warehouseQueryBean);
        ModelAndView mav = new ModelAndView("/businessOutletEdit");
        mav.addObject("businessOutlet", businessOutlet);
        mav.addObject("warehouseList", warehouseList);
        mav.addObject("districtList", districtList);
        return mav;
    }
    /**
     * 修改自提点方法
     *
     * @param businessOutlet
     * @return ModelAndView
     */
    @RequestMapping(value = "/businessOutletEdit", method = RequestMethod.POST)
    public ModelAndView businessOutletEdit(BusinessOutlet businessOutlet) {
        businessOutletService.updateBusinessOutlet(businessOutlet);
        businessOutlet = businessOutletService.getBusinessOutletByBusinessOutletId(businessOutlet.getId());
        Warehouse warehouse = warehouseService.getWarehouseByWarehouseId(businessOutlet.getWarehouseId());
        List<Warehouse> warehouseList = warehouseService.getWarehouseList(new WarehouseQueryBean());
        ModelAndView mav = new ModelAndView("/businessOutletEdit");
        mav.addObject("businessOutlet", businessOutlet);
        mav.addObject("warehouse", warehouse);
        mav.addObject("warehouseList", warehouseList);
        return mav;

    }





    /**
     * 查询自提点列表页面跳转方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/businessOutletListPage", method = RequestMethod.GET)
    public ModelAndView businessOutletListPage() {
        ModelAndView mav = new ModelAndView("/businessOutletList");

        return mav;

    }

    /**
     * 查询自提点列表方法
     *
     * @param
     * @return ModelAndView
     */
    @RequestMapping(value = "/businessOutletList", method = RequestMethod.GET)
    public ModelAndView businessOutletList(BusinessOutletQueryBean businessOutletQueryBean) {

        ModelAndView mav = new ModelAndView("/businessOutletList");
        List<BusinessOutlet> businessOutletList = businessOutletService.getBusinessOutletList(businessOutletQueryBean);
        List<District> districtList = warehouseService.getDistrictList(new DistrictQueryBean());
        Map<Integer,District> districtMap = new HashMap<>();
        for(District district:districtList){
            districtMap.put(district.getId(),district);
        }
        for(BusinessOutlet businessOutlet:businessOutletList){
            businessOutlet.setDistrict(districtMap.get(businessOutlet.getDistrictId()));
        }
        mav.addObject("businessOutletQueryBean", businessOutletQueryBean);
        mav.addObject("businessOutletList", businessOutletList);

        mav.addObject("districtList", districtList);
        return mav;

    }

    @RequestMapping(value = "/getWarehouseListByDistrictId/{id}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> getWarehouseListByDistrictId(@PathVariable int id) throws Exception {
        log.info("id={}", id);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (id < 0) {
            modelMap.put("result", false);
            return modelMap;
        }

        List<Warehouse> warehouseList = warehouseService.getWarehouseListByDistrictId(id);
//        log.info("list={}", warehouseList);
        modelMap.put("warehouseList", warehouseList);
        return modelMap;
    }


}
