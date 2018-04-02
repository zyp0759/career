package cn.pingweb.career.service;

import cn.pingweb.career.model.Apply;

import java.util.List;

public interface ApplyService {

    void save(Apply apply);

    List<Apply> findByUserId(String userId);

    Apply findById(String id);

    List<Apply> findByWorkId(String workId);

    List<Apply> findAll();

    void remove(String id);

}
