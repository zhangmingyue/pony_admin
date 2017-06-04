package com.pony_admin.BusinessOutletAndWarehouse.entity.QueryBean;

/**
 * Created by Administrator on 2017/6/1 0001.
 */
public class BusinessOutletQueryBean {


    private String businessOutletName;
    private int districtId;

//    setter and getter

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getBusinessOutletName() {
        return businessOutletName;
    }

    public void setBusinessOutletName(String businessOutletName) {
        this.businessOutletName = businessOutletName;
    }

}
