package com.xlibaba.travel.dao.impl;

import com.xlibaba.travel.dao.IRouteDAO;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.util.myutils.DBUtil;

import java.util.List;

/**
 * @author ChenWang
 * @className RouteDAOImpl
 * @date 2020/10/21 10:23
 * @since JDK 1.8
 */
public class RouteDAOImpl implements IRouteDAO {
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
    public List<Route> getAbroad() {
        return DBUtil.getDbUtil().excuteQuery(BASE_SQL+" WHERE cid = 6 OR cid = 8 ORDER BY price desc LIMIT 0,4",Route.class);
    }

    @Override
    public List<Route> getDomestic() {
        return DBUtil.getDbUtil().excuteQuery(BASE_SQL+" WHERE cid = 5 ORDER BY price desc LIMIT 0,6",Route.class);
    }

    @Override
    public List<Route> getExpensive() {
        return DBUtil.getDbUtil().excuteQuery(BASE_SQL+" ORDER BY price desc LIMIT 0,4",Route.class);
    }

    @Override
    public List<Route> getHot() {
        return DBUtil.getDbUtil().excuteQuery(BASE_SQL+" ORDER BY count desc LIMIT 0,4",Route.class);
    }

    @Override
    public List<Route> getNew() {
        return DBUtil.getDbUtil().excuteQuery(BASE_SQL+" ORDER BY  rdate desc LIMIT 0,4",Route.class);
    }

    @Override
    public List<Route> getTheme() {
        return DBUtil.getDbUtil().excuteQuery(BASE_SQL+" WHERE rflag = 1 ORDER BY price desc LIMIT 0,4",Route.class);
    }
}
