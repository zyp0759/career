package cn.pingweb.career.service.impl;

import cn.pingweb.career.dao.ScholarshipDAO;
import cn.pingweb.career.service.ScholarshipService;
import cn.pingweb.career.model.Scholarship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScholarshipServiceImpl implements ScholarshipService {

    private ScholarshipDAO scholarshipDAO;

    @Autowired
    public ScholarshipServiceImpl(ScholarshipDAO scholarshipDAO) {
        this.scholarshipDAO = scholarshipDAO;
    }

    @Override
    public void save(Scholarship scholarship) {
        scholarshipDAO.save(scholarship);
    }

    @Override
    public Scholarship findById(String id) {
        return scholarshipDAO.findOne(id);
    }

    @Override
    public List<Scholarship> findBySource(String source) {
        return scholarshipDAO.findBySourceLike(source);
    }

    @Override
    public List<Scholarship> findByLevel(String level) {
        return scholarshipDAO.findByLevelLike(level);
    }

    @Override
    public List<Scholarship> findByUserId(String userId) {
        return scholarshipDAO.findByUserId(userId);
    }

    @Override
    public void remove(String id) {
        scholarshipDAO.delete(id);
    }

}
