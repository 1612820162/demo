package com.example.demo.service;


import com.example.demo.entity.User;
import com.example.demo.entity.ret.RetResult;


public interface UserService {

    /**
     * 根据用户名查询用户信息（用来登录验证）
     */
    String login(String userName, String password);

    /**
     * 根据id查询用户信息
     */
    RetResult<User> getOne(String id);

    /**
     * 查询表中所有用户数据
     */
    RetResult<User> getAll();

    /**
     * 根据性别查询用户信息
     */
    RetResult<User> getBySex(String sex);

    /**
     * 插入一条用户信息
     */
    RetResult<User> insert(User user);

    /**
     * 更新用户信息
     */
    RetResult<User> update(User user);

    /**
     * 根据用户名删除用户信息
     */
    RetResult<User> delete(String userName);

    /**
     * 删除表中所有用户信息
     */
    RetResult<User> deleteAll();

}
