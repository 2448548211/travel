package com.xlibaba.travel.dao;

import com.xlibaba.travel.entity.Route;

import java.util.List;

/**
 * @author ChenWang
 * @interfaceName IRouteDAO
 * @date 2020/10/21 10:22
 * @since JDK 1.8
 */
public interface IRouteDAO {
    List<Route> getAbroad();

    List<Route> getDomestic();

    List<Route> getExpensive();

    List<Route> getHot();

    List<Route> getNew();

    List<Route> getTheme();
}
