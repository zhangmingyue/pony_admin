package com.pony_admin.domain;

import java.util.Date;

/**
 * 预约类
 *
 * @author: qiaoyi
 * @edit:
 * @created:17/3/4
 */
public class ReservationEntity {
    private int id;
    private String name;
    private String url;
    private Date date;
    private String reservationPicUrl;
    private int reservationPicHeight;
    private int reservationPicWidth;

    //setter and getter


    public String getReservationPicUrl() {
        return reservationPicUrl;
    }

    public void setReservationPicUrl(String reservationPicUrl) {
        this.reservationPicUrl = reservationPicUrl;
    }

    public int getReservationPicHeight() {
        return reservationPicHeight;
    }

    public void setReservationPicHeight(int reservationPicHeight) {
        this.reservationPicHeight = reservationPicHeight;
    }

    public int getReservationPicWidth() {
        return reservationPicWidth;
    }

    public void setReservationPicWidth(int reservationPicWidth) {
        this.reservationPicWidth = reservationPicWidth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", date=" + date +
                '}';
    }
}
