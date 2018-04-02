package cn.pingweb.career.dto;

import cn.pingweb.career.model.Apply;
import cn.pingweb.career.model.BaseInfo;
import cn.pingweb.career.model.Work;

import java.io.Serializable;
import java.util.Date;

public class ApplyDto implements Serializable{
    private String userId;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String position;
    private Date time;

    public ApplyDto() {
    }

    public ApplyDto(Apply apply, Work work, BaseInfo baseInfo) {
        this.userId = apply.getUserId();
        this.name = baseInfo.getName();
        this.gender = baseInfo.getGender().equals("1")?"男":"女";
        this.phone = baseInfo.getPhone();
        this.email = baseInfo.getEmail();
        this.position = work.getName();
        this.time = apply.getTime();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
