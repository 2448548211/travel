package com.xlibaba.travel.service.page;

import com.xlibaba.travel.entity.Route;

import java.util.List;

/**
 * @author ChenWang
 * @className IndexTopPage
 * @date 2020/10/21 11:01
 * @since JDK 1.8
 */
public class IndexTopPage {
    private List<Route> topExpensive;
    private List<Route> topHot;
    private List<Route> topNew;
    private List<Route> topTheme;

    public List<Route> getTopExpensive() {
        return topExpensive;
    }

    public void setTopExpensive(List<Route> topExpensive) {
        this.topExpensive = topExpensive;
    }

    public List<Route> getTopHot() {
        return topHot;
    }

    public void setTopHot(List<Route> topHot) {
        this.topHot = topHot;
    }

    public List<Route> getTopNew() {
        return topNew;
    }

    public void setTopNew(List<Route> topNew) {
        this.topNew = topNew;
    }

    public List<Route> getTopTheme() {
        return topTheme;
    }

    public void setTopTheme(List<Route> topTheme) {
        this.topTheme = topTheme;
    }
}
