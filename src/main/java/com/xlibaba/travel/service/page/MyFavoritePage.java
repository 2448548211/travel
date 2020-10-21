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
    //当前页
    private Integer currentPage;
    //总条数
    private int totalCount;
    //总页数
    private int pageCount;
    //每页展示的数据行
    private int pageSize;
    //请求地址
    private String url;
    private List<Route> routes;

    public MyFavoritePage(){}


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        if(this.pageSize > 0 && totalCount > 0){
            this.pageCount = totalCount%pageSize == 0?totalCount/pageSize:totalCount/pageSize+1;
        }
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        if(this.pageSize > 0 && totalCount > 0){
            this.pageCount = totalCount%pageSize == 0?totalCount/pageSize:totalCount/pageSize+1;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
