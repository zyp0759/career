package cn.pingweb.career.dto;

import cn.pingweb.career.model.WorkExperience;

import java.util.ArrayList;
import java.util.List;

public class WorkExperienceDto {

    private String id;

    private String company;

    private String position;

    private String start;

    private String end;

    private String description;

    private String startYear;

    private String startMonth;

    private String endYear;

    private String endMonth;

    public WorkExperienceDto() {
    }

    public static List<WorkExperienceDto> getDtos(List<WorkExperience> workExperiences){
        List<WorkExperienceDto> workExperienceDtos = new ArrayList<>();
        for(WorkExperience workExperience : workExperiences) {
            workExperienceDtos.add(new WorkExperienceDto(workExperience));
        }
        return workExperienceDtos;
    }

    public WorkExperienceDto(WorkExperience workExperience) {
        this.id = workExperience.getId();
        this.company = workExperience.getCompany();
        this.position = workExperience.getPosition();
        this.start = workExperience.getStart();
        this.end = workExperience.getEnd();
        this.description = workExperience.getDescription();
        String[] temp1 = start.split("\\.");
        this.startYear = temp1[0];
        this.startMonth = temp1[1];
        String[] temp2 = end.split("\\.");
        this.endYear = temp2[0];
        this.endMonth = temp2.length!=2? "":temp2[1];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
