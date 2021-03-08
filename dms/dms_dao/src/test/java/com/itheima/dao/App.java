package com.itheima.dao;

import com.itheima.dao.user.UserDao;
import com.itheima.domain.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-dao.xml")
public class App {
    @Autowired
    private UserDao userDao;

    @Test
    public void test(){
        User user = userDao.selectByPrimaryKey("111");
        System.out.println(user);

//        List<User> list = userDao.findAll();
    }
}
