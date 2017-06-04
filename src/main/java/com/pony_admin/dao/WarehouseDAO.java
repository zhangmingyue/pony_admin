package com.pony_admin.dao;

import com.pony_admin.AdvertisementAndSpecial.entity.Advertisement;
import com.pony_admin.AdvertisementAndSpecial.entity.QueryBean.AdvertisementQueryBean;
import com.pony_admin.BusinessOutletAndWarehouse.entity.District;
import com.pony_admin.BusinessOutletAndWarehouse.entity.QueryBean.DistrictQueryBean;
import com.pony_admin.BusinessOutletAndWarehouse.entity.QueryBean.WarehouseQueryBean;
import com.pony_admin.BusinessOutletAndWarehouse.entity.Warehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface WarehouseDAO {


    /**
     * 根据查询条件获取仓库列表
     *
     * @param warehouseQueryBean
     * @return List<Warehouse>
     */
    public List<Warehouse> getWarehouseList(WarehouseQueryBean warehouseQueryBean);

    /**
     * 根据仓库ID获取仓库
     *
     * @param warehousetId
     * @return Warehouse
     */
    public Warehouse getWarehouseByWarehouseId(@Param("warehousetId") int warehousetId);

    /**
     * 根据查询条件获取仓库列表
     *
     * @param districtId
     * @return List<Warehouse>
     */
    public List<Warehouse> getWarehouseListByDistrictId(@Param("districtId") int districtId);

    /**
     * 添加仓库
     *
     * @param warehouse
     * @return int
     */
    public int addWarehouse(Warehouse warehouse);

    /**
     * 修改仓库
     *
     * @param warehouse
     * @return void
     */
    public void updateWarehouse(Warehouse warehouse);

    /**
     * 根据查询条件获取地区列表
     *
     * @param districtQueryBean
     * @return List<District>
     */
    public List<District> getDistrictList(DistrictQueryBean districtQueryBean);

    /**
     * 根据仓地区ID获取地区
     *
     * @param districtId
     * @return District
     */
    public District getDistrictByDistrictId(@Param("districtId") int districtId);

    /**
     * 添加地区
     *
     * @param district
     * @return int
     */
    public int addDistrict(District district);

    /**
     * 修改地区
     *
     * @param district
     * @return void
     */
    public void updateDistrict(District district);
}
