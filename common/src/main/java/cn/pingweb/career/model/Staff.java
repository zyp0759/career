package cn.pingweb.career.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Staff {

    public static final String ADMIN = "admin";
    public static final String COMPANY = "company";

    @Id
    private String id;

    private String email;

    private String pwd;

    private String type;

    public Staff() {
    }

    public Staff(String id, String email, String pwd) {
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.type = Staff.COMPANY;
    }

    public Staff(String id, String email, String pwd, String type) {
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
