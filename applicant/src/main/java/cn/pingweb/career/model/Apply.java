package cn.pingweb.career.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Apply {

    @Id
    private String applyId;

    @Column(length = 20)
    private String userId;

    @Column(length = 20)
    private String workId;

    private Date time;

    // 投递状态
    private String state;

    public Apply() {
    }

    public Apply(String applyId, String userId, String workId, Date time) {
        this.applyId = applyId;
        this.userId = userId;
        this.workId = workId;
        this.time = time;
        this.state = "等待面试";
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
