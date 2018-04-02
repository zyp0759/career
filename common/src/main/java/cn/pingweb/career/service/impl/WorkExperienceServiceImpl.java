package cn.pingweb.career.service.impl;

import cn.pingweb.career.dao.WorkExperienceDao;
import cn.pingweb.career.model.WorkExperience;
import cn.pingweb.career.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {

    @Autowired
    private WorkExperienceDao workExperienceDao;

    @Override
    public void save(WorkExperience workExperience) {
        workExperienceDao.save(workExperience);
    }

    @Override
    public WorkExperience findById(String id) {
        return workExperienceDao.findOne(id);
    }

    @Override
    public List<WorkExperience> findByUserId(String userId) {
        return workExperienceDao.findByUserId(userId);
    }

    @Override
    public void remove(String id) {
        workExperienceDao.delete(id);
    }
}
