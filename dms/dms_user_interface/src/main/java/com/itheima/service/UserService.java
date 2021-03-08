package com.itheima.service;


import com.github.pagehelper.PageInfo;
import com.itheima.domain.user.User;
import com.itheima.domain.user.UserExample;

public interface UserService {
    /**
     * 分页查询
     *
     * @param example
     * @param pageNum
     * @param pageSize
     * @return
     */

    PageInfo<User> findAll(UserExample example, int pageNum, int pageSize);

    /**
     * 保存用户信息
     *
     * @param user
     */
    void save(User user);

    /**
     * 修改用户信息
     *
     * @param user
     */
    void update(User user);

    /**
     * 根据用户id查用户信息
     */
    User findById(String id);

    /**
     * 删除用户信息
     */
    String  delete(String id);

}
