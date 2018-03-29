package cn.pingweb.career.service;

import cn.pingweb.career.model.Scholarship;

import java.util.List;

public interface ScholarshipService {

    void save(Scholarship scholarship);

    Scholarship findById(String id);

    List<Scholarship> findBySource(String source);

    List<Scholarship> findByLevel(String level);

    List<Scholarship> findByUserId(String userId);

    void remove(String id);
}
