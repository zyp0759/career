package cn.pingweb.career.service;

import cn.pingweb.career.model.Work;

import java.util.List;

public interface WorkService {

    void save(Work work);

    Work findById(String id);

    List<Work> findByUserId(String userId);

    List<Work> findAll();

    void remove(String id);

}
