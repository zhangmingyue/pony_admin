package com.pony_admin.domain;

import java.util.Date;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/9
 */
public class SelfServiceUser {
    private int id;
    private String nickname;
    private String phone;
    private String email;
    private String password;
    private Date create_time;
    private Date last_login_time;
    private int status;
    private int role;
    private String url;
    private int businessoutletId;
    private int warehouseId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getBusinessoutletId() {
        return businessoutletId;
    }

    public void setBusinessoutletId(int businessoutletId) {
        this.businessoutletId = businessoutletId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public String toString() {
        return "SelfServiceUser{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", create_time=" + create_time +
                ", last_login_time=" + last_login_time +
                ", status=" + status +
                ", role=" + role +
                ", url='" + url + '\'' +
                ", businessoutletId=" + businessoutletId +
                ", warehouseId=" + warehouseId +
                '}';
    }
}
