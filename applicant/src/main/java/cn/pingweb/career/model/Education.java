package cn.pingweb.career.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Date;

//@IdClass(EducationKey.class)
@Entity
public class Education implements Comparable{

    @Id
    private String educationId;

    @Column(length = 20)
    private String userId;

    private String start;

    private String end;

    @Column(length = 30)
    private String school;

    @Column(length = 50)
    private String department;

    @Column(length = 50)
    private String major;

    @Column(length = 20)
    private String degree;

    @Column(length = 10)
    private String rank;

    private Date createTime;

    public Education() {
    }

    public Education(String educationId, String userId, String start, String end, String school, String major, String degree) {
        this.educationId = educationId;
        this.userId = userId;
        this.start = start;
        this.end = end;
        this.school = school;
        this.department = "";
        this.major = major;
        this.degree = degree;
        this.rank = "";
        this.createTime = new Date();
    }

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public int compareTo(Object o) {
        return this.createTime.compareTo(((Education) o).getCreateTime());
    }
}

//class EducationKey implements Serializable{
//    private String educationId;
//    private String userId;
//
//    public String getEducationId() {
//        return educationId;
//    }
//
//    public void setEducationId(String educationId) {
//        this.educationId = educationId;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//}