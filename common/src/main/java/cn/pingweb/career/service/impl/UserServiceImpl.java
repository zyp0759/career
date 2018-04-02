package cn.pingweb.career.service.impl;

import cn.pingweb.career.dao.UserDAO;
import cn.pingweb.career.model.User;
import cn.pingweb.career.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserById(String userId) {
        return userDAO.findOne(userId);
    }

    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }
}
