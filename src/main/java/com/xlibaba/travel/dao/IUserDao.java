package com.xlibaba.travel.dao;

import com.xlibaba.travel.entity.User;

import java.util.List;

public interface IUserDao {
    //查询全表
    public List<User>listUserAll();

    //通过用户名查询用户数据
    public User getUserByName(String name);

    //添加用户
    public int insertUser(User user);

    //修改
    public int updateUser(User user);

    //删除
    public int deleteUser(String name);

    Integer getIdByName(String username);
}
