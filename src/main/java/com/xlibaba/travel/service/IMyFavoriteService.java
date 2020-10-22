package com.xlibaba.travel.service;

import com.xlibaba.travel.service.page.MyFavoritePage;

/**
 * @author ChenWang
 * @interfaceName IMyFavoriteService
 * @date 2020/10/21 20:19
 * @since JDK 1.8
 */
public interface IMyFavoriteService {

    MyFavoritePage getMyFavoritePage(String username, Integer currentPage);

    Integer getIdByName(String username);
}
