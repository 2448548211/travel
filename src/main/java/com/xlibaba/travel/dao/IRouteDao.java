package com.xlibaba.travel.dao;

import com.xlibaba.travel.entity.Route;

import java.util.List;

/**
 * @author ChenWang
 * @interfaceName IRouteDao
 * @date 2020/10/22 08:53
 * @since JDK 1.8
 */
public interface IRouteDao {
    List<Route> selectRoutesByName(String routeName, int startIndex, int num);

    List<Route> selectRoutes(int startIndex, int num);

    Route selectRouteById(int id);

    List<Route> getAbroad();

    List<Route> getDomestic();

    List<Route> getExpensive();

    List<Route> getHot();

    List<Route> getNew();

    List<Route> getTheme();

    //获取总记录数
    public int getSum();

    //根据路线名字查询所有
    public int getSumByName(String routeName);
}
