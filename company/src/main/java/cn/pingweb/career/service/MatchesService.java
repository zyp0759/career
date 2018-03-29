package cn.pingweb.career.service;

import cn.pingweb.career.model.Matches;

import java.util.List;

public interface MatchesService {

    void save(Matches match);

    Matches findById(String id);

    List<Matches> findByName(String name);

    List<Matches> findByLevel(String level);

    List<Matches> findByUserId(String userId);

    void remove(String id);

}
