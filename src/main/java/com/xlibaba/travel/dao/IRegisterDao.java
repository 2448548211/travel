package com.xlibaba.travel.dao;

import com.xlibaba.travel.entity.User;

/**
 * @author chenxiaosong
 */
public interface IRegisterDao {
    /**
     * 用户注册
     * 通过username查询用户名是否已存在
     * @param username 用户名  --  用户帐号
     * @return 存在返回 1 不存在返回 0
     */
    int checkUserName(String username);
    /**
     * 注册新用户
     * @param user 新用户对象
     * @return 注册成功返回 1，失败返回 0
     */
    int insertUser(User user);
}
