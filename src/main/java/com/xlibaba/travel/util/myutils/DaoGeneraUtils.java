package com.xlibaba.travel.util.myutils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: travel
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-10-20 15:00
 **/
public class DaoGeneraUtils<T> {

    //private static DBUtil dbUtil = DBUtil.getDbUtil();

    //反射属性对象
    private Class<T> clz;

    //为全局反射属性对象赋值
    public DaoGeneraUtils(Class<T> clazz) {
        this.clz = clazz;
    }

    public DaoGeneraUtils() {}


    /**
     * 查询所有数据
     * @param tabName   要查询的表名
     * @return
     */
    public List<T> selectAll(String tabName) {
        //拼接sql语句
        StringBuffer sql_select = new StringBuffer("SELECT ");

        //通过反射对象获取所有属性对象
        Field[] fields = clz.getDeclaredFields();
        String name = null;
        for (Field f : fields) {
            FieldColName ann = f.getAnnotation(FieldColName.class);
            if (ann == null || ann.value().equals("")){
                name = f.getName();
            } else {
                name = ann.value();
            }
            sql_select = sql_select.append(name).append(",");
        }
        sql_select.deleteCharAt(sql_select.lastIndexOf(",")).append(" FROM "+tabName+" WHERE is_del=0");
        System.out.println(sql_select);

        //查询数据
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql_select.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                try {
                    T t = clz.newInstance();
                    for (int i = 0; i < fields.length; i++) {
                        //取消访问权限
                        fields[i].setAccessible(true);
                        //获取字段数据
                        Object value = rs.getObject(i+1);
                        //给对象中的属性赋值
                        fields[i].set(t,value);
                    }
                    list.add(t);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.closeAll(conn,ps,rs);
        }
        return list;
    }


    /**
     * 通过SQL语句查询数据表中所有数据
     * @param sql   SQL语句
     * @return
     */
    public List<T> selectSql(String sql) {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //通过反射对象获取所有属性对象
        Field[] fields = clz.getDeclaredFields();
        List<T> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                try {
                    T t = clz.newInstance();
                    for (int i = 0; i < fields.length; i++) {
                        //取消访问权限
                        fields[i].setAccessible(true);
                        //获取字段数据
                        Object value = rs.getObject(i+1);
                        //给对象中的属性赋值
                        fields[i].set(t,value);
                    }
                    list.add(t);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.closeAll(conn,ps,rs);
        }
        return list;
    }


    /**
     * 通过数据表中的某个字段查询数据
     * @param tabName   要查询的表名
     * @param idName    条件查询的字段
     * @param name        数值
     * @return
     */
    public T selectByID(String tabName,String idName,Object name) {
        String sql_select = "SELECT ";
        sql_select = sql_select.concat(getAllColumnNameString(clz)).concat(" FROM "+tabName+" WHERE is_del=0 AND "+idName+"=?");
        System.out.println(sql_select);
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //通过反射对象获取所有属性对象
        Field[] fields = clz.getDeclaredFields();
        T t = null;
        try {
            ps = conn.prepareStatement(sql_select.toString());
            ps.setObject(1,name);
            rs = ps.executeQuery();
            if (rs.next()) {
                try {
                    t = clz.newInstance();
                    for (int i = 0; i < fields.length; i++) {
                        //取消访问权限
                        fields[i].setAccessible(true);
                        //获取字段数据
                        Object value = rs.getObject(i+1);
                        //给对象中的属性赋值
                        fields[i].set(t,value);
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.closeAll(conn,ps,rs);
        }
        return t;
    }


    public int insertSQL(String sql) {

        return 0;
    }


    /**
     *  修改数据表数据
     * @param tabName   表名
     * @param t         数据表对应的数据表实体类对象
     * @param idName    设置条件字段
     * @param name        数值
     * @return
     */
    public int updateDB(String tabName,T t,String idName,Object name) {
        String allColumnName = getAllColumnNameString(clz).replaceAll(",","=?,").concat("=?");
        String sql = "UPDATE "+tabName+" SET "+allColumnName+"  WHERE "+idName+"=?";
        System.out.println(sql);

        //通过反射对象获取所有属性对象
        Field[] fields = clz.getDeclaredFields();

        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int line = 0;
        try {
            ps = conn.prepareStatement(sql);
            int ind = 1;
            for (Field field : fields) {
                try {
                    //取消访问权限
                    field.setAccessible(true);
                    //获取属性值,并进行赋值
                    ps.setObject(ind++,field.get(t));
                    System.out.println(field.get(t));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            ps.setObject(ind++,name);
            line = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return line;
    }


    /**
     *  通过数据表中的某个字段删除数据
     * @param tabName   要查询的表名
     * @param idName    条件查询的字段
     * @param name        数值
     * @return
     */
    public int deleteDB(String tabName,String idName,Object name) {
        String sql = "UPDATE "+tabName+" SET is_del=1 WHERE "+idName+"=?";
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int line = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,name);
            line = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return line;
    }


    /**
     * 获取实体类对应数据表的所有列名所组成的字符串
     * @param clz   反射类对象
     * @param <T>
     * @return
     */
    private static <T> String getAllColumnNameString(Class<T> clz) {
        //拼接sql语句
        StringBuffer sql_select = new StringBuffer("");
        //通过反射对象获取所有属性对象
        Field[] fields = clz.getDeclaredFields();
        String name = null;
        for (Field f : fields) {
            FieldColName ann = f.getAnnotation(FieldColName.class);
            if (ann == null || ann.value().equals("")){
                name = f.getName();
            } else {
                name = ann.value();
            }
            sql_select = sql_select.append(name).append(",");
        }
        sql_select.deleteCharAt(sql_select.lastIndexOf(","));
        return sql_select.toString();
    }
}
