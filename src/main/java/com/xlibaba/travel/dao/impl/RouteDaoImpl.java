package com.xlibaba.travel.dao.impl;

import com.xlibaba.travel.dao.IRouteDao;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.util.myutils.DBUtil;

import javax.management.relation.Role;
import java.util.List;

public class RouteDaoImpl implements IRouteDao {

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
        return DBUtil.getDbUtil().excuteQuery(sql, Route.class,routeName).size();
    }
}
