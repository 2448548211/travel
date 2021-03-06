package com.xlibaba.travel.dao.impl;

import com.xlibaba.travel.dao.IRegisterDao;
import com.xlibaba.travel.entity.User;
import com.xlibaba.travel.util.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author chenxiaosong
 */
public class RegisterDaoImpl implements IRegisterDao {
    @Override
    public int checkUserName(String username) {
        String sql = "select count(*) from tab_user where username=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rSet = ps.executeQuery();
            if (rSet.next()) {
                count = rSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps,rSet);
        }
        return count;
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into tab_user(username, password, name, sex, telephone, email) values (?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        int rSet = 0;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getSex());
            ps.setString(5, user.getTelephone());
            ps.setString(6, user.getEmail());
            rSet = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps);
        }
        return rSet;
    }
}
