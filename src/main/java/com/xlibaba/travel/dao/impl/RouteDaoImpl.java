package com.xlibaba.travel.dao.impl;

import com.xlibaba.travel.dao.IRouteDao;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.util.myutils.DBUtil;

import java.util.List;

public class RouteDaoImpl implements IRouteDao {

    @Override
    public List<Route> selectRoutesByName(String routeName, int startIndex, int num) {
        String sql = "select * from tab_route where name like \"%?%\" limit ?,?";
        if (routeName == null || routeName == "") {
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
}
