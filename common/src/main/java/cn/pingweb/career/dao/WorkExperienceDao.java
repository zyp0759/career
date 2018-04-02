package cn.pingweb.career.dao;

import cn.pingweb.career.model.WorkExperience;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkExperienceDao extends CrudRepository<WorkExperience, String> {
    List<WorkExperience> findByUserId(String userId);
}
