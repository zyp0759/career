package cn.pingweb.career.service;

import cn.pingweb.career.model.BaseInfo;

import java.util.List;

public interface BaseInfoService {

    void save(BaseInfo baseInfo);

    BaseInfo getbyId(String id);

    List<BaseInfo> getAll();

    void remove(String id);

}
