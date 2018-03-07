package cn.pingweb.career.service;

import cn.pingweb.career.model.Education;

import java.util.List;

public interface EducationService {

    void save(Education education);

    List<Education> getByUserId(String userId);

    Education getById(String id);

    List<Education> getAll();

    void remove(String id);

}
