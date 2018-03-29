package cn.pingweb.career.model;

import javax.persistence.*;

@Entity
public class SelfDescription {

    @Id
    private String userId;

    @Lob
    private String description;

    public SelfDescription() {
    }

    public SelfDescription(String userId, String description) {
        this.userId = userId;
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
