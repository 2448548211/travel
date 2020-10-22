package com.xlibaba.travel.dao.impl;

import com.xlibaba.travel.dao.IUserDao;
import com.xlibaba.travel.entity.User;
import com.xlibaba.travel.util.myutils.DBUtil;
import com.xlibaba.travel.util.myutils.DaoGeneraUtils;
import com.xlibaba.travel.util.myutils.SingleSqlUtil;

import java.util.List;

/**
 * @program: travel
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-10-20 23:59
 **/
public class UserDaoImpl implements IUserDao {

    //创建反射工具类对象
    DaoGeneraUtils<User> daoUtils = new DaoGeneraUtils(User.class);

    @Override
    public List<User> listUserAll() {
        String sql = "select * FROM tab_user WHERE is_del=0";
        return daoUtils.selectAll("tab_user");
    }

    @Override
    public User getUserByName(String name) {
        return daoUtils.selectByID("tab_user","username",name);
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
        return daoUtils.deleteDB("tab_user","username",name);
    }

    @Override
    public Integer getIdByName(String username) {
        String sql = "SELECT uid From tab_user WHERE username = ?";
        return SingleSqlUtil.excuteQuery(Integer.class,sql,username);
    }
}
