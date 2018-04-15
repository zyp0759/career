package cn.pingweb.career.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BaseInfo {

    @Id
    private String id;

    private String name = "未完善";

    private String gender = "男";

    private String birthday = "0000-00-00";

    @Column(length = 11)
    private String phone = "未完善";

    private String email = "未完善";

    private String education = "未完善";

    private String workYear = "-1";

    private String headIcon = "";

    public BaseInfo() {

    }

    public BaseInfo(String id) {
        this.id = id;
    }

    public BaseInfo(String id, String name, String gender, String birthday, String phone, String email, String education, String workYear) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.education = education;
        this.workYear = workYear;
        this.headIcon = "";
    }

    public BaseInfo(String id, String name, String gender, String birthday, String phone, String email, String education, String workYear, String headIcon) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.education = education;
        this.workYear = workYear;
        this.headIcon = headIcon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }
}
