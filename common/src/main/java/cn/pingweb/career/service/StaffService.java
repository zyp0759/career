package cn.pingweb.career.service;

import cn.pingweb.career.model.Staff;

public interface StaffService {

    Staff getStaffById(String id);

    Staff getStaffByEmail(String email);

    void saveStaff(Staff staff);

}
