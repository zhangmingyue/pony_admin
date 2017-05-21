package com.pony_admin.AdvertisementAndSpecial.entity.QueryBean;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class SpecialQueryBean {

    //专题ID
    private int specialId;
    //题目
    private String title;
    //查询开始时间
    private String beginTime;
    //查询结束时间
    private String endTime;


    //getter and setter


    public int getSpecialId() {
        return specialId;
    }

    public void setSpecialId(int specialId) {
        this.specialId = specialId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
