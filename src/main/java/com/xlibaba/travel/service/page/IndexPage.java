package com.xlibaba.travel.service.page;

import com.xlibaba.travel.entity.Route;

import java.util.List;

/**
 * @author ChenWang
 * @className IndexPage
 * @date 2020/10/21 10:09
 * @since JDK 1.8
 */
public class IndexPage {
    /*精选页*/
    private IndexTopPage top;
    /*国内路线*/
    private List<Route> mid;
    /*国外路线*/
    private List<Route> foot;
    /*国内块图片*/
    private String midImg;
    /*国外块图片*/
    private String footImg;
    public IndexPage() {
    }

    public String getMidImg() {
        return midImg;
    }

    public void setMidImg(String midImg) {
        this.midImg = midImg;
    }

    public String getFootImg() {
        return footImg;
    }

    public void setFootImg(String footImg) {
        this.footImg = footImg;
    }

    public IndexTopPage getTop() {
        return top;
    }

    public void setTop(IndexTopPage top) {
        this.top = top;
    }

    public List<Route> getMid() {
        return mid;
    }

    public void setMid(List<Route> mid) {
        this.mid = mid;
    }

    public List<Route> getFoot() {
        return foot;
    }

    public void setFoot(List<Route> foot) {
        this.foot = foot;
    }
}
