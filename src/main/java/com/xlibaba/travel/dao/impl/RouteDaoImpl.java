package com.xlibaba.travel.dao.impl;

import com.xlibaba.travel.dao.IRouteDao;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.util.myutils.DBUtil;

import java.util.List;

public class RouteDaoImpl implements IRouteDao {

    private static final String BASE_SQL = "SELECT rid," +
            "rname," +
            "price," +
            "routeIntroduce," +
            "rflag," +
            "rdate," +
            "isThemeTour," +
            "count," +
            "cid," +
            "rimage," +
            "sid," +
            "sourceId FROM tab_route";

    @Override
    public List<Route> selectRoutesByName(String routeName, int startIndex, int num) {
        String sql = "select * from tab_route where rname regexp ? limit ?,?";
        if (routeName == null || routeName.equals("")) {
            return selectRoutes(startIndex, num);
        }
        List<Route> routes = DBUtil.getDbUtil().excuteQuery(sql, Route.class, routeName, startIndex, num);
        return routes;
    }

    @Override
    public List<Route> selectRoutes(int startIndex, int num) {
        String sql = "select * from tab_route limit ?,?";
        return DBUtil.getDbUtil().excuteQuery(sql, Route.class, startIndex, num);
    }

    @Override
    public Route selectRouteById(int id) {
        String sql = "select * from tab_route where rid=?";
        return DBUtil.getDbUtil().excuteQuery(sql, Route.class, id).get(0);
    }

    @Override
    public int getSum() {
        String sql = "select * from tab_route";
        return DBUtil.getDbUtil().excuteQuery(sql, Route.class).size();
    }

    @Override
    public int getSumByName(String routeName) {
        String sql = "select * from tab_route where rname regexp ?";
        return DBUtil.getDbUtil().excuteQuery(sql, Route.class, routeName).size();
    }

    @Override
    public List<Route> getAbroad() {
        return DBUtil.getDbUtil().excuteQuery(BASE_SQL + " WHERE cid = 6 OR cid = 8 ORDER BY price desc LIMIT 0,4", Route.class);
    }

    @Override
    public List<Route> getDomestic() {
        return DBUtil.getDbUtil().excuteQuery(BASE_SQL + " WHERE cid = 5 ORDER BY price desc LIMIT 0,6", Route.class);
    }

    @Override
    public List<Route> getExpensive() {
        return DBUtil.getDbUtil().excuteQuery(BASE_SQL + " ORDER BY price desc LIMIT 0,4", Route.class);
    }

    @Override
    public List<Route> getHot() {
        return DBUtil.getDbUtil().excuteQuery(BASE_SQL + " ORDER BY count desc LIMIT 0,4", Route.class);
    }

    @Override
    public List<Route> getNew() {
        return DBUtil.getDbUtil().excuteQuery(BASE_SQL + " ORDER BY  rdate desc LIMIT 0,4", Route.class);
    }

    @Override
    public List<Route> getTheme() {
        return DBUtil.getDbUtil().excuteQuery(BASE_SQL + " WHERE rflag = 1 ORDER BY price desc LIMIT 0,4", Route.class);
    }
}
