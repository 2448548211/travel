package com.xlibaba.travel.util.myutils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenWang
 * @className SingleSqlUtil
 * @date 2020/10/22 00:03
 * @since JDK 1.8
 */
public class SingleSqlUtil{
    /**
     *  返回查询的第一列第一行的数据，返回数据类型由传入的类对象约束
     * @param clz   传入的类对象是为了约束泛型T
	 * @param sql   指定的sql语句
	 * @param params    sql语句中指定的参数
     * @return T    返回泛型T，由传入的类对象约束
     * @author ChenWang
     * @date 2020/10/22 00:23
     */
    public static<T> T excuteQuery(Class<T> clz,String sql,Object...params){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        List<T> list = null;
        T t = null;
        try{
            conn = DBUtil.getDbUtil().getConnection();
            ps = conn.prepareStatement(sql);
            setParams(ps,params);
            rSet = ps.executeQuery();

            if(rSet.next()){
                t = clz.cast(rSet.getObject(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("网络延迟，请稍后再试");
        }finally {
            DBUtil.getDbUtil().closeAll(rSet,ps,conn);
        }
        return t;
    }
    /**
     * 将参数传入对应的sql指定参量中
     * @param ps        指定的预编译sql
     * @param params    对应的参数数组
     * @author ChenWang
     * @date 2020/10/23 16:18
     */
    private static void setParams(PreparedStatement ps, Object... params) throws SQLException {
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
        }
    }
}
