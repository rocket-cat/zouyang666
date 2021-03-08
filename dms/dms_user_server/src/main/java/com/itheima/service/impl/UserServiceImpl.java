package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.user.UserDao;
import com.itheima.domain.user.User;
import com.itheima.domain.user.UserExample;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<User> findAll(UserExample example, int pageNum, int pageSize) {
        //开启分页支持
        PageHelper.startPage(pageNum, pageSize);

        //根据企业id查所有用户
       List<User> list = userDao.selectByExample(example);

        //存入用户数据并返回
       return new PageInfo<>(list);
    }

    @Override
    public void save(User user) {
        //设置用户ID
        user.setId(UUID.randomUUID().toString());
        //保存
        userDao.insertSelective(user);
    }

    @Override
    public void update(User user) {
        userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public User findById(String id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public String delete(String id) {
        return null;
    }

}
