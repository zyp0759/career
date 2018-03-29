package cn.pingweb.career.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Scholarship {

    @Id
    private String scholarshipId;

    @Column(length = 20)
    private String userId;

    private String source;

    private String level;

    private Date time;

    private Date createTime;

    public Scholarship() {
    }

    public Scholarship(String scholarshipId, String userId, String source, String level, Date time) {
        this.scholarshipId = scholarshipId;
        this.userId = userId;
        this.source = source;
        this.level = level;
        this.time = time;
        this.createTime = new Date();
    }

    public String getScholarshipId() {
        return scholarshipId;
    }

    public void setScholarshipId(String scholarshipId) {
        this.scholarshipId = scholarshipId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

//class SchoolarShipKey implements Serializable{
//    private String scholarshipId;
//    private String userId;
//
//    public String getScholarshipId() {
//        return scholarshipId;
//    }
//
//    public void setScholarshipId(String scholarshipId) {
//        this.scholarshipId = scholarshipId;
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
