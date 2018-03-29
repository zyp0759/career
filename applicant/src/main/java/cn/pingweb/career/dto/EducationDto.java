package cn.pingweb.career.dto;

import cn.pingweb.career.enums.EducationDegree;
import cn.pingweb.career.model.Education;

import java.util.ArrayList;
import java.util.List;

public class EducationDto {
    private String educationId;
    private String start;
    private String end;
    private String school;
    private String major;
    private String degree;

    public EducationDto() {
    }

    public EducationDto(Education education) {
        this.educationId = education.getEducationId();
        this.start = education.getStart();
        this.end = education.getEnd();
        this.school = education.getSchool();
        this.major = education.getMajor();
        for (EducationDegree educationDegree : EducationDegree.values()) {
            if(educationDegree.getDegreeValue().equals(education.getDegree())) {
                this.degree = educationDegree.getDegreeName();
                break;
            }
        }

    }

    public static List<EducationDto> getDto(List<Education> educations) {
        List<EducationDto>dtos = new ArrayList<>();
        for (Education education : educations) {
            dtos.add(new EducationDto(education));
        }
        return dtos;
    }

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
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
}
