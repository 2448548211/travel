package com.xlibaba.travel.dao;

import com.xlibaba.travel.entity.Route;

import java.util.List;

public interface IRouteDao {
    //根据路线名查询所有路线,分页
    public List<Route> selectRoutesByName(String routeName, int startIndex, int num);

    //没关键字查询所有路线
    public List<Route> selectRoutes(int startIndex, int num);

    //以id查询路线
    public Route selectRouteById(int id);
}
