package com.xlibaba.travel.service;

import com.xlibaba.travel.service.page.MyFavoritePage;

/**
 * @author ChenWang
 * @interfaceName IMyFavoriteService
 * @date 2020/10/21 20:19
 * @since JDK 1.8
 */
public interface IMyFavoriteService {
    /**
     * 获取我的收藏指定页码的页面数据
     * @param username          指定用户名
	 * @param currentPage       指定页码
     * @return  MyFavoritePage  页面数据
     * @author ChenWang
     * @date 2020/10/23 14:35
     */
    MyFavoritePage getMyFavoritePage(String username, Integer currentPage);
    /**
     * 通过名字获取ID值
     * @param username      指定名字
     * @return Integer      返回ID
     * @author ChenWang
     * @date 2020/10/23 14:36
     */
    Integer getIdByName(String username);
}
