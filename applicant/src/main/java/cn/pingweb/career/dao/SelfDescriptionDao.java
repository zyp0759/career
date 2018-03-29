package cn.pingweb.career.dao;

import cn.pingweb.career.model.SelfDescription;
import org.springframework.data.repository.CrudRepository;

public interface SelfDescriptionDao extends CrudRepository<SelfDescription, String> {
}
