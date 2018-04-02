package cn.pingweb.career.service;


import cn.pingweb.career.model.SelfDescription;

public interface SelfDescriptionService {

    void save(SelfDescription selfDescription);

    SelfDescription findById(String id);

    void remove(String id);

    String getSelfDescription(String id);
}
