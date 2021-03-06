package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.IUserDao;
import com.xlibaba.travel.dao.impl.UserDaoImpl;
import com.xlibaba.travel.entity.User;
import com.xlibaba.travel.service.ILoginService;

import java.util.List;

/**
 * @program: travel
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-10-21 00:38
 **/
public class LoginServiceImpl implements ILoginService {

    //创建dao对象
    IUserDao dao = new UserDaoImpl();

    @Override
    public List<User> listUserAll() {
        return dao.listUserAll();
    }

    @Override
    public User getUserByName(String name) {
        return dao.getUserByName(name);
    }

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(String name) {
        return 0;
    }
}
