package cn.pingweb.career.service.impl;

import cn.pingweb.career.dao.SelfDescriptionDao;
import cn.pingweb.career.model.SelfDescription;
import cn.pingweb.career.service.SelfDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SelfDescriptionServiceImpl implements SelfDescriptionService {

    @Autowired
    private SelfDescriptionDao selfDescriptionDao;

    @Override
    public void save(SelfDescription selfDescription) {
        selfDescriptionDao.save(selfDescription);
    }

    @Override
    public SelfDescription findById(String id) {
        return selfDescriptionDao.findOne(id);
    }

    @Override
    public void remove(String id) {
        selfDescriptionDao.delete(id);
    }

    @Override
    public String getSelfDescription(String id) {
        SelfDescription selfDescription = this.findById(id);
        return selfDescription==null ? "" : selfDescription.getDescription();
    }
}
