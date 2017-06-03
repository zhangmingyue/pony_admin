package com.pony_admin.BusinessOutletAndWarehouse.entity;

/**
 * Created by Administrator on 2017/6/1 0001.
 */
public class District {

    private int id;
    //仓库名字
    private String districtName;


    //setter and getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
