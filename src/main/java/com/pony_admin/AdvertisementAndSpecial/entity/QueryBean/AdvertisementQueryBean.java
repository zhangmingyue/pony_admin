package com.pony_admin.AdvertisementAndSpecial.entity.QueryBean;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class AdvertisementQueryBean {

    //广告ID
    private int advertisementId = 0;
    //广告名称
    private String advertisementName ;
    //查询开始时间
    private String beginTime ;
    //查询结束时间
    private String endTime ;


    //getter and setter


    public int getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(int advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getAdvertisementName() {
        return advertisementName;
    }

    public void setAdvertisementName(String advertisementName) {
        this.advertisementName = advertisementName;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
