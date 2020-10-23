package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.IRegisterDao;
import com.xlibaba.travel.dao.impl.RegisterDaoImpl;
import com.xlibaba.travel.entity.User;
import com.xlibaba.travel.service.IRegisterService;

/**
 * @author chenxiaosong
 */
public class RegisterService implements IRegisterService {
    IRegisterDao registerDao = new RegisterDaoImpl();
    /**
     * 检查用户名
     * @param username  指定的用户名
     * @return
     * @date 2020/10/23 14:45
     */
    @Override
    public int checkUserName(String username) {
        return registerDao.checkUserName(username);
    }
    /**
     * 插入用户数据
     * @param user  指定的用户数据
     * @return int  影响的行数
     * @date 2020/10/23 14:46
     */
    @Override
    public int insertUser(User user) {
        return registerDao.insertUser(user);
    }
}
