package cn.pingweb.career.service.impl;

import cn.pingweb.career.dao.ProjectExperienceDao;
import cn.pingweb.career.model.ProjectExperience;
import cn.pingweb.career.service.ProjectExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectExperienceServiceImpl implements ProjectExperienceService {

    @Autowired
    private ProjectExperienceDao projectExperienceDao;

    @Override
    public void save(ProjectExperience projectExperience) {
        projectExperienceDao.save(projectExperience);
    }

    @Override
    public ProjectExperience findById(String id) {
        return projectExperienceDao.findOne(id);
    }

    @Override
    public List<ProjectExperience> findByUserId(String userId) {
        return projectExperienceDao.findByUserId(userId);
    }

    @Override
    public void remove(String id) {
        projectExperienceDao.delete(id);
    }
}
