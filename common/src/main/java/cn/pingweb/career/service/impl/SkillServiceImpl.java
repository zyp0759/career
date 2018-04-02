package cn.pingweb.career.service.impl;

import cn.pingweb.career.dao.SkillDao;
import cn.pingweb.career.model.Skill;
import cn.pingweb.career.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SkillServiceImpl implements SkillService{

    @Autowired
    private SkillDao skillDao;

    @Override
    public void save(Skill skill) {
        skillDao.save(skill);
    }

    @Override
    public Skill findById(String id) {
        return skillDao.findOne(id);
    }

    @Override
    public void remove(String id) {
        skillDao.delete(id);
    }

    @Override
    public String getSkillContent(String id) {
        Skill skill = this.findById(id);
        return skill==null ? "" : skill.getDescription();
    }
}
