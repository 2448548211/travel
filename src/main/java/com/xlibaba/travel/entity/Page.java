package com.xlibaba.travel.entity;

import java.util.List;

public class Page {
    private int currentPage;
    private int pageSize = 8;
    private int pageCount;
    private int sum;
    private List list;
    private String url;

    @Override
    public String toString() {
        return "page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", list=" + list +
                ", sum=" + sum +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
        this.pageCount = sum % pageSize == 0 ? sum / pageSize : (sum / pageSize + 1);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        if (this.sum != 0) {
            this.pageCount = sum % pageSize == 0 ? sum / pageSize : (sum / pageSize + 1);
        }
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Page(int currentPage, int pageSize, List<User> list, int sum, String url) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.list = list;
        this.sum = sum;
        this.url = url;
        this.pageCount = sum % pageSize == 0 ? sum / pageSize : (sum / pageSize + 1);
    }

    public Page() {
    }
}
