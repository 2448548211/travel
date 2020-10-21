package com.xlibaba.travel.service;

import com.xlibaba.travel.entity.Page;
import com.xlibaba.travel.entity.Route;

import java.util.List;

public interface IRouteService {
    //根据路线名查询所有路线，分页
    public Page selectRoutesByName(String routeName, int currentPage);

    //以id查询路线
    public Route selectRouteById(int id);
}
