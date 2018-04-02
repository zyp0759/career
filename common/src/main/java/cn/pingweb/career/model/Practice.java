package cn.pingweb.career.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Date;

@Entity
public class Practice {

    @Id
    private String practiceId;

    private String userId;

    private Date start;

    private Date end;

    private String name;

    @Lob
    private String content;

    @Lob
    private String duty;

    private Date createTime;

    public Practice() {
    }

    public Practice(String practiceId, String userId, Date start, Date end, String name, String content, String duty) {
        this.practiceId = practiceId;
        this.userId = userId;
        this.start = start;
        this.end = end;
        this.name = name;
        this.content = content;
        this.duty = duty;
        this.createTime = new Date();
    }

    public String getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(String practiceId) {
        this.practiceId = practiceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

//class PracticKey implements Serializable{
//    private
//}