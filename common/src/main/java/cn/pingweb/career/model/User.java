package cn.pingweb.career.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

//    public static final String APPLICANT = "applicant";
//    public static final String ADMIN = "admin";
//    public static final String COMPANY = "company";

    @Id
    private String userId;

    private String email;

    @Column(length = 16)
    private String pwd;

//    @Column(length = 15)
//    private String type;

    public User() {
    }

    public User(String userId, String email, String pwd) {
        this.userId = userId;
        this.email = email;
        this.pwd = pwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
