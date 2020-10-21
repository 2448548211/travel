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
    @Override
    public int checkUserName(String username) {
        return registerDao.checkUserName(username);
    }

    @Override
    public int insertUser(User user) {
        return registerDao.insertUser(user);
    }
}
