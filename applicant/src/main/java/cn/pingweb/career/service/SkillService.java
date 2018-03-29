package cn.pingweb.career.service;


import cn.pingweb.career.model.Skill;

public interface SkillService {

    void save(Skill skill);

    Skill findById(String id);

    void remove(String id);

    String getSkillContent(String id);
}
