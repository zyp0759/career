package cn.pingweb.career.dao;

import cn.pingweb.career.model.ProjectExperience;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectExperienceDao extends CrudRepository<ProjectExperience, String> {
    List<ProjectExperience> findByUserId(String userId);
}
