package com.pony_admin.BusinessOutletAndWarehouse.entity;

/**
 * Created by Administrator on 2017/6/1 0001.
 */
public class Warehouse {

    private int id;
    //仓库名字
    private String warehouseName;
    private int districtId = 0;
    private District district;
    //setter and getter

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }
}
