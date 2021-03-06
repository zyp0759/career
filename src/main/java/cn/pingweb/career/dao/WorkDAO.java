package cn.pingweb.career.dao;

import cn.pingweb.career.model.Work;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkDAO extends CrudRepository<Work, String> {

    List<Work> findByUserId(String userId);

}
