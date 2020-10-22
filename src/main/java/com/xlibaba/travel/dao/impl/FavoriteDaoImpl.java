package com.xlibaba.travel.dao.impl;

import com.xlibaba.travel.dao.IFavoriteDao;
import com.xlibaba.travel.entity.Favorite;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.util.myutils.DBUtil;
import com.xlibaba.travel.util.myutils.DBUtils;
import com.xlibaba.travel.util.myutils.DaoGeneraUtils;
import com.xlibaba.travel.util.myutils.SingleSqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ChenWang
 * @className FavoriteDaoImpl
 * @date 2020/10/21 20:42
 * @since JDK 1.8
 */
public class FavoriteDaoImpl implements IFavoriteDao {
    @Override
    public List<Route> getListById(Integer id, int pageId, int pageSize) {
        Integer offset = (pageId-1)*12;
        String sql = "SELECT r.rid," +
                "r.rname," +
                "r.price," +
                "r.routeIntroduce," +
                "r.rflag," +
                "r.rdate," +
                "r.isThemeTour," +
                "r.count," +
                "r.cid," +
                "r.rimage," +
                "r.sid," +
                "r.sourceId FROM tab_route r LEFT JOIN " +
                " tab_favorite f ON r.rid=f.rid WHERE f.uid = ? limit ?,?";
        return DBUtil.getDbUtil().excuteQuery(sql,Route.class,id,offset,pageSize);
    }
    @Override
    public int getTotalCount(Integer id) {
        String sql = "SELECT COUNT(rid) FROM tab_favorite WHERE uid = ?";
        //注意此处返回的值是Long包装类，不能直接强转为int型，要通过其封装的方法进行强转
        return SingleSqlUtil.excuteQuery(Long.class,sql,id).intValue();
    }

    DaoGeneraUtils daoUtil = new DaoGeneraUtils();

    @Override
    public int insertFavorite(Favorite favorite) {
        String sql = "INSERT INTO tab_favorite(rid,date,uid) values(?,?,?);";
        /*Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        int line = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,favorite.getRid());
            ps.setString(2,favorite.getDate());
            ps.setInt(3,favorite.getUid());
            line = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.closeAll(conn,ps);
        }
        return line;*/
        return daoUtil.insertSQL(sql,favorite.getRid(),favorite.getDate(),favorite.getUid());
    }

    @Override
    public int deleteFavorite(int rid) {
        return 0;
    }
}
