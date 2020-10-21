package com.xlibaba.travel.dao.impl;

import com.xlibaba.travel.dao.IFavoriteDao;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.util.myutils.DBUtil;
import com.xlibaba.travel.util.myutils.SingleSqlUtil;

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
}
