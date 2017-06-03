package com.pony_admin.BusinessOutletAndWarehouse.entity;

/**
 * Created by Administrator on 2017/6/1 0001.
 */
public class BusinessOutlet {

    private int id;
    private String businessOutletName;
    private int warehouseId;
    private int districtId;
    private District district;
//    setter and getter


    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusinessOutletName() {
        return businessOutletName;
    }

    public void setBusinessOutletName(String businessOutletName) {
        this.businessOutletName = businessOutletName;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }
}
