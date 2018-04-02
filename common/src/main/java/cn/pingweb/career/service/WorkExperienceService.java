package cn.pingweb.career.service;

import cn.pingweb.career.model.WorkExperience;

import java.util.List;

public interface WorkExperienceService {
    void save(WorkExperience workExperience);

    WorkExperience findById(String id);

    List<WorkExperience> findByUserId(String userId);

    void remove(String id);
}
