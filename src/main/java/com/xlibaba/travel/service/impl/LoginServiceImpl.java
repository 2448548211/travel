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
    /**
     * 获取所有的用户数据
     * @return  List<User>  所有的用户数据集合
     * @date 2020/10/23 14:49
     */
    @Override
    public List<User> listUserAll() {
        return dao.listUserAll();
    }
    /**
     * 依据名字获取用户
     * @param name  指定用户名
     * @return User 用户
     * @date 2020/10/23 14:50
     */
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
