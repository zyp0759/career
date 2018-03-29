package cn.pingweb.career.service.impl;

import cn.pingweb.career.dao.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void getUserById() throws Exception {
        System.out.println(userDAO.findOne("123456@qq.com"));
    }

    @Test
    public void saveUser() throws Exception {
    }

}