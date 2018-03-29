package cn.pingweb.career.dao;

import cn.pingweb.career.model.Skill;
import org.springframework.data.repository.CrudRepository;

public interface SkillDao extends CrudRepository<Skill, String> {
}
