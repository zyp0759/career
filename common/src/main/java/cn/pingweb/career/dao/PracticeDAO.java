package cn.pingweb.career.dao;

import cn.pingweb.career.model.Practice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PracticeDAO extends CrudRepository<Practice, String> {

    List<Practice> findByUserId(String userId);

}
