package cn.pingweb.career.dao;

import cn.pingweb.career.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, String> {

}
