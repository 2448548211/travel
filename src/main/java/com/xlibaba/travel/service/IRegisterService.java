package com.xlibaba.travel.service;

import com.xlibaba.travel.entity.User;

/**
 * @author chenxiaosong
 */
public interface IRegisterService {
    /**
     * 查询帐号是否存在
     * @param username 用户帐号
     * @return 存在返回 1，存在返回 0
     */
    int checkUserName(String username);

    /**
     * 注册新用户
     * @param user 新用户user对象
     * @return 注册成功返回 1，失败返回 0
     */
    int insertUser(User user);
}
