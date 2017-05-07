package com.pony_admin.controller;

import com.google.common.base.Strings;
import com.pony_admin.domain.DistrictEntity;
import com.pony_admin.domain.ResidentialAreaEntity;
import com.pony_admin.domain.SelfLiftingCabinetEntity;
import com.pony_admin.service.DistrictService;
import com.pony_admin.service.ResidentialAreaService;
import com.pony_admin.service.SelfLiftingCabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
@Controller
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    DistrictService districtService;
    @Autowired
    ResidentialAreaService residentialAreaService;
    @Autowired
    SelfLiftingCabinetService selfLiftingCabinetService;

    @RequestMapping(value = "/district")
    public String getPageDistrict(Model model,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        return "address_district";
    }

    @RequestMapping(value = "/residential_area")
    public String getPageResidentialArea(Model model,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
        List<DistrictEntity> district = districtService.getAllList();
        model.addAttribute("district", district);
        return "address_residential_area";
    }

    @RequestMapping(value = "/cabinet")
    public String getCabinet(Model model,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        List<ResidentialAreaEntity> residentialAreaEntities = residentialAreaService.getAllList();
        model.addAttribute("cabinet", residentialAreaEntities);
        return "address_cabinet";
    }

    @RequestMapping(value = "/add_district", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addDistrict(HttpServletRequest request,
                                           HttpServletResponse response) {
        Map<String, Object> model = new HashMap<>();
        String districtName = request.getParameter("district_name");
        if (Strings.isNullOrEmpty(districtName)) {
            model.put("result", false);
            model.put("msg", "参数为空");
            return model;
        }

        DistrictEntity districtEntity = new DistrictEntity();
        districtEntity.setDistrictName(districtName);
        if (districtService.insert(districtEntity) >= 1) {
            model.put("result", true);
            return model;
        }

        model.put("result", false);
        model.put("msg", "服务器未知错误");
        return model;
    }

    @RequestMapping(value = "/add_residential_area", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addResidential(HttpServletRequest request,
                                              HttpServletResponse response) {
        Map<String, Object> model = new HashMap<>();
        String district = request.getParameter("district");
        String residential = request.getParameter("residential");
        String building = request.getParameter("building");
        String house = request.getParameter("house");
        String housePrice = request.getParameter("house_price");
        String cabinetCount = request.getParameter("cabinet_count");
        String rentOne = request.getParameter("rent_one");
        String rentTwo = request.getParameter("rent_two");
        String rentThree = request.getParameter("rent_three");

        if (Strings.isNullOrEmpty(district) || Strings.isNullOrEmpty(residential)) {
            model.put("result", false);
            model.put("msg", "参数为空");
            return model;
        }

        ResidentialAreaEntity residentialAreaEntity = new ResidentialAreaEntity();
        residentialAreaEntity.setDistricId(Integer.parseInt(district));
        residentialAreaEntity.setResidentialAreaName(residential);
        residentialAreaEntity.setBuilding(Integer.parseInt(building));
        residentialAreaEntity.setHouse(Integer.parseInt(house));
        residentialAreaEntity.setHousePrice(Integer.parseInt(housePrice));
        residentialAreaEntity.setCarbinetCount(Integer.parseInt(cabinetCount));
        residentialAreaEntity.setRentOne(Integer.parseInt(rentOne));
        residentialAreaEntity.setRentTwo(Integer.parseInt(rentTwo));
        residentialAreaEntity.setRentThree(Integer.parseInt(rentThree));

        if (residentialAreaService.insert(residentialAreaEntity) >= 1) {
            model.put("result", true);
            return model;
        }
        model.put("result", false);
        model.put("msg", "服务器未知错误");
        return model;
    }

    @RequestMapping(value = "/cabinet_add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addCabinet(HttpServletRequest request,
                                          HttpServletResponse response) {

        Map<String, Object> model = new HashMap<>();
        String cabinetNumber = request.getParameter("cabinet_number");
        //TODO 自提点id
        String businessOutletId = request.getParameter("business_outlet_id");
        //// TODO: 供货id 
        String warehouseId = request.getParameter("warehouse_id");
        String stockingBase = request.getParameter("stocking_base");
        String residentialAreaId = request.getParameter("residential_area_id");
        String location = request.getParameter("location");

        model.put("result", false);

        if (Strings.isNullOrEmpty(cabinetNumber) || Strings.isNullOrEmpty(businessOutletId) ||
                Strings.isNullOrEmpty(warehouseId) || Strings.isNullOrEmpty(stockingBase) ||
                Strings.isNullOrEmpty(residentialAreaId) || Strings.isNullOrEmpty(location)) {
            model.put("msg", "参数不正确");
            return model;
        }
        ResidentialAreaEntity residentialAreaEntity = residentialAreaService.getResidentialById(Integer.parseInt(residentialAreaId));
        if (residentialAreaEntity == null) {
            model.put("msg", "二级数据获取错误");
            return model;
        }
        SelfLiftingCabinetEntity selfLiftingCabinetEntity = new SelfLiftingCabinetEntity();
        selfLiftingCabinetEntity.setCabinetNumber(cabinetNumber);
        selfLiftingCabinetEntity.setBusinessOutletId(Integer.parseInt(businessOutletId));
        selfLiftingCabinetEntity.setDistrictId(residentialAreaEntity.getDistricId());
        selfLiftingCabinetEntity.setWarehouseId(Integer.parseInt(warehouseId));
        selfLiftingCabinetEntity.setStockingBase(Integer.parseInt(stockingBase));
        selfLiftingCabinetEntity.setResidentialAreaId(Integer.parseInt(residentialAreaId));
        selfLiftingCabinetEntity.setLocation(location);

        if (selfLiftingCabinetService.insert(selfLiftingCabinetEntity) >= 1) {
            model.put("result", true);
            return model;
        }

        model.put("msg", "服务器内部错误");
        return model;
    }
}
