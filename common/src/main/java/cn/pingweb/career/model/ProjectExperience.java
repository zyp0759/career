package cn.pingweb.career.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ProjectExperience implements Comparable{
    @Id
    private String id;

    private String userId;

    private String name;

    private String position;

    private String start;

    private String end;

    private String description;

    private Date createTime;

    public ProjectExperience() {
    }

    public ProjectExperience(String id, String userId, String name, String position, String start, String end, String description) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.position = position;
        this.start = start;
        this.end = end;
        this.description = description;
        this.createTime = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public int compareTo(Object o) {
        return this.createTime.compareTo(((ProjectExperience) o).getCreateTime());
    }
}
