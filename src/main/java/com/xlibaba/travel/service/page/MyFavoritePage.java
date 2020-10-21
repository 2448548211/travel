package com.xlibaba.travel.service.page;

import com.xlibaba.travel.entity.Route;

import java.util.List;

/**
 * @author ChenWang
 * @className MyFavoritePage
 * @date 2020/10/21 20:24
 * @since JDK 1.8
 */
public class MyFavoritePage {
    private Integer pageId;
    private List<Route> routes;

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
