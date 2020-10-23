package com.xlibaba.travel.service.page;

import java.util.List;

/**
 * @author ChenWang
 * @className HeaderPage
 * @date 2020/10/20 23:04
 * @since JDK 1.8
 */
public class HeaderPage {
    /*用户名*/
    private String username;
    /*导航栏*/
    private List<String> navBar;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNavBar(List<String> navBar) {
        this.navBar = navBar;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getNavBar() {
        return navBar;
    }
}
