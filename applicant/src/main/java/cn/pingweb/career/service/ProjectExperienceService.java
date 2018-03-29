package cn.pingweb.career.service;

import cn.pingweb.career.model.ProjectExperience;

import java.util.List;

public interface ProjectExperienceService {
    void save(ProjectExperience workExperience);

    ProjectExperience findById(String id);

    List<ProjectExperience> findByUserId(String userId);

    void remove(String id);
}
