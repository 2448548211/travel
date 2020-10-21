package com.xlibaba.travel.service.entity;

import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.entity.RouteImg;

import java.util.List;

/**
 * @program: travel
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-10-21 14:01
 **/
public class Detail {
    private Route route;
    private List<String> routeImgList;

    public Detail() {
    }

    public Detail(Route route, List<String> routeImgList) {
        this.route = route;
        this.routeImgList = routeImgList;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "route=" + route +
                ", routeImgList=" + routeImgList +
                '}';
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<String> getRouteImgList() {
        return routeImgList;
    }

    public void setRouteImgList(List<String> routeImgList) {
        this.routeImgList = routeImgList;
    }
}
