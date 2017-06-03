package com.pony_admin.BusinessOutletAndWarehouse.service;


import com.pony_admin.BusinessOutletAndWarehouse.entity.District;
import com.pony_admin.BusinessOutletAndWarehouse.entity.QueryBean.DistrictQueryBean;
import com.pony_admin.BusinessOutletAndWarehouse.entity.QueryBean.WarehouseQueryBean;
import com.pony_admin.BusinessOutletAndWarehouse.entity.Warehouse;

import com.pony_admin.dao.WarehouseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告serviceImpl
 * Created by Administrator on 2017/3/11 0011.
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseDAO warehouseDAO;



    /**
     * 根据查询条件获取仓库列表
     *
     * @param warehouseQueryBean
     * @return List<Warehouse>
     */
    public List<Warehouse> getWarehouseList(WarehouseQueryBean warehouseQueryBean){
        List<Warehouse> warehouseList = warehouseDAO.getWarehouseList(warehouseQueryBean);
        District district;
        for(Warehouse warehouse:warehouseList){
            district = warehouseDAO.getDistrictByDistrictId(warehouse.getDistrictId());
            if(district == null){
                district = new District();
            }
            warehouse.setDistrict(district);
        }
        return warehouseList;
    }

    /**
     * 根据仓库ID获取仓库
     *
     * @param warehousetId
     * @return Warehouse
     */
    public Warehouse getWarehouseByWarehouseId(int warehousetId){
        return  warehouseDAO.getWarehouseByWarehouseId(warehousetId);
    }

    /**
     * 根据查询条件获取仓库列表
     *
     * @param districtId
     * @return List<Warehouse>
     */
    public List<Warehouse> getWarehouseListByDistrictId(int districtId){
        return  warehouseDAO.getWarehouseListByDistrictId(districtId);
    }

    /**
     * 添加仓库
     *
     * @param warehouse
     * @return int
     */
    public int addWarehouse(Warehouse warehouse){
        return  warehouseDAO.addWarehouse(warehouse);
    }

    /**
     * 修改仓库
     *
     * @param warehouse
     * @return void
     */
    public void updateWarehouse(Warehouse warehouse){
        warehouseDAO.updateWarehouse(warehouse);
    }

    /**
     * 根据查询条件获取地区列表
     *
     * @param districtQueryBean
     * @return List<District>
     */
    public List<District> getDistrictList(DistrictQueryBean districtQueryBean){
        return  warehouseDAO.getDistrictList(districtQueryBean);
    }

    /**
     * 根据仓地区ID获取地区
     *
     * @param districtId
     * @return District
     */
    public District getDistrictByDistrictId(int districtId){
        return  warehouseDAO.getDistrictByDistrictId(districtId);
    }

    /**
     * 添加地区
     *
     * @param district
     * @return int
     */
    public int addDistrict(District district){
        return  warehouseDAO.addDistrict(district);
    }

    /**
     * 修改地区
     *
     * @param district
     * @return void
     */
    public void updateDistrict(District district){
        warehouseDAO.updateDistrict(district);
    }

}
