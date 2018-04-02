package cn.pingweb.career.dao;

import cn.pingweb.career.model.OtherInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OtherInfoDAO extends CrudRepository<OtherInfo, String> {

    List<OtherInfo> findByUserId(String userId);

    List<OtherInfo> findByCity(String city);

}
