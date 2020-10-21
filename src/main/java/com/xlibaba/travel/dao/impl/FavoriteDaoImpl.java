package com.xlibaba.travel.dao.impl;

import com.xlibaba.travel.dao.IFavoriteDao;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.util.myutils.DBUtil;

import java.util.List;

/**
 * @author ChenWang
 * @className FavoriteDaoImpl
 * @date 2020/10/21 20:42
 * @since JDK 1.8
 */
public class FavoriteDaoImpl implements IFavoriteDao {
    @Override
    public List<Route> getListById(Integer id) {
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
                "r.sourceId FROM tab_route r LEFT JOIN ON" +
                " tab_favorite f ON r.rid=f.rid WHERE f.rid = ?";
        return DBUtil.getDbUtil().excuteQuery(sql,Route.class,id);
    }
}
