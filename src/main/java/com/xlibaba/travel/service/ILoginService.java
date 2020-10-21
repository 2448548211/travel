package com.xlibaba.travel.service;

import com.xlibaba.travel.entity.User;

import java.util.List;

public interface ILoginService {
    //查询全表
    public List<User> listUserAll();

    //通过用户名查询用户数据
    public User getUserByName(String name);

    //添加用户
    public int insertUser(User user);

    //修改
    public int updateUser(User user);

    //删除
    public int deleteUser(String name);
}
