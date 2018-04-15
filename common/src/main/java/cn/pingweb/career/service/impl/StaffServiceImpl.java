package cn.pingweb.career.service.impl;

import cn.pingweb.career.dao.StaffDAO;
import cn.pingweb.career.model.Staff;
import cn.pingweb.career.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDAO staffDAO;

    @Override
    public Staff getStaffById(String id) {
        return staffDAO.findOne(id);
    }

    @Override
    public Staff getStaffByEmail(String email) {
        return staffDAO.findByEmail(email);
    }

    @Override
    public void saveStaff(Staff staff) {
        staffDAO.save(staff);
    }
}
