package cn.pingweb.career.dao;

import cn.pingweb.career.model.Staff;
import org.springframework.data.repository.CrudRepository;

public interface StaffDAO extends CrudRepository<Staff, String> {

    Staff findByEmail(String email);

}
