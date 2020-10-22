package com.xlibaba.travel.entity;

import java.io.Serializable;

/**
 * 收藏实体类
 */
public class Favorite implements Serializable {
    private Route route;//旅游线路对象
    private User user;//所属用户

    private int rid;    //旅游线路对象id
    private String date;//收藏时间
    private int uid;    //所属用户id

    /**
     * 无参构造方法
     */
    public Favorite() {
    }

    public Favorite(int rid, String date, int uid) {
        this.rid = rid;
        this.date = date;
        this.uid = uid;
    }

    /**
     * 有参构造方法
     * @param route
     * @param date
     * @param user
     */
    public Favorite(Route route, String date, User user) {
            this.route = route;
            this.date = date;
            this.user = user;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "route=" + route +
                ", user=" + user +
                ", rid=" + rid +
                ", date='" + date + '\'' +
                ", uid=" + uid +
                '}';
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
