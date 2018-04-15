package cn.pingweb.career.service;

import cn.pingweb.career.model.User;

public interface UserService {

    User getUserById(String userId);

    User getUserByEmail(String email);

    void saveUser(User user);

}
