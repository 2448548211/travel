package com.xlibaba.travel.entity;

import java.util.List;

/**
 * @Author: Ram
 * @Since: 2020.10.21 14:42
 */
public class FavoriteData {
    //当前页
    private int currentPage;
    //总条数
    private int totalCount;
    //每页展示数据行
    private int pageSize;
    //总页数
    private int pageCount;
    //数据集合
    private List<?> list;
    //请求地址

    public FavoriteData() {
    }

    public FavoriteData(int currentPage, int totalCount, int pageSize, int pageCount, List<?> list) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.list = list;
        //3.直接在构造方法中进行设置
        this.pageCount = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;

    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        //设置总页数
        if(this.pageSize > 0 && totalCount > 0){
            this.pageCount = totalCount%pageSize == 0?totalCount/pageSize:totalCount/pageSize+1;
        }
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

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
