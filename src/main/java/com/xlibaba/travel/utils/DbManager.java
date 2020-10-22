package com.xlibaba.travel.utils;

import com.xlibaba.travel.entity.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ram
 * @Since: 2020.10.21 13:49
 */
public class DbManager {
    /**
     *  指定sql查询
     * @param sql 语句
     * @return 数据集合
     */
    public static List<Route> selectSql(String sql){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        ArrayList<Route> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rSet = ps.executeQuery();
            while (rSet.next()){
                int rid = rSet.getInt(1);
                String rname = rSet.getString(2);
                double price = rSet.getDouble(3);
                int count = rSet.getInt(4);
                String rimage = rSet.getString(5);
                int sid = rSet.getInt(6);
                Route route = new Route(rid,rname,price,count,rimage,sid);
                list.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rSet,ps,conn);
        }
        return list;
    }

    /**
     * 获取数据总条数
     * @param sql 语句
     * @return 总行数
     */
    public static int getTotalCount(String sql) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        int count = 0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rSet = ps.executeQuery();
            if (rSet.next()){
                count = rSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rSet,ps,conn);
        }
        return count;
    }
}
