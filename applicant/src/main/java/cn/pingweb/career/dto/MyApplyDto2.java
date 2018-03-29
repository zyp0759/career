package cn.pingweb.career.dto;

import java.io.Serializable;
import java.util.Date;

public class MyApplyDto2 implements Serializable {
    private Date time;
    private String jobName;
    private String state;

    public MyApplyDto2(Date time, String jobName, String state) {
        this.time = time;
        this.jobName = jobName;
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}