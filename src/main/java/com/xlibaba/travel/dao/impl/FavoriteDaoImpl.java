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
import java.sql.ResultSet;
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
                " tab_favorite f ON r.rid=f.rid WHERE f.uid = ? AND f.is_del = 1 limit ?,?";
        return DBUtil.getDbUtil().excuteQuery(sql,Route.class,id,offset,pageSize);
    }
    @Override
    public int getTotalCount(Integer id) {
        String sql = "SELECT COUNT(rid) FROM tab_favorite WHERE uid = ? AND is_del = 1";
        //注意此处返回的值是Long包装类，不能直接强转为int型，要通过其封装的方法进行强转
        return SingleSqlUtil.excuteQuery(Long.class,sql,id).intValue();
    }

    DaoGeneraUtils daoUtil = new DaoGeneraUtils();

    @Override
    public int insertFavorite(Favorite favorite) {
        String sql = "INSERT INTO tab_favorite(rid,date,uid) values(?,?,?);";
        return daoUtil.insertSQL(sql,favorite.getRid(),favorite.getDate(),favorite.getUid());
    }

    //删除
    @Override
    public int deleteFavorite(int rid, int uid) {
        String sql = "UPDATE tab_favorite SET is_del=0 WHERE rid=? AND uid=?";
        return daoUtil.deleteSQL(sql, rid, uid);
    }

    /**
     * 通过rid和uid查询收藏表数据,返回null为未收藏
     * @param rid
     * @param uid
     * @param del   del:0已删除的数据数据,1未已删除的数据数据
     * @return
     */
    @Override
    public Favorite getFavorite(int rid, int uid, int del) {
        String sql = "SELECT * FROM tab_favorite WHERE is_del=? AND rid=? AND uid=?;";
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Favorite favorite = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,del);
            ps.setInt(2,rid);
            ps.setInt(3,uid);
            rs = ps.executeQuery();
            if (rs.next()) {
                favorite = new Favorite();
                favorite.setRid(rs.getInt(1));
                favorite.setDate(rs.getDate(2).toString());
                favorite.setUid(rs.getInt(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.closeAll(conn,ps,rs);
        }
        return favorite;
    }

    //恢复已删除的数据
    @Override
    public int restoreFavorite(int rid, int uid) {
        String sql = "UPDATE tab_favorite SET is_del=1 WHERE rid=? AND uid=?";
        return daoUtil.deleteSQL(sql, rid, uid);
    }
}
