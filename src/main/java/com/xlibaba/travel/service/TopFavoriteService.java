package com.xlibaba.travel.service;

import com.xlibaba.travel.entity.FavoriteData;

/**
 * @Author: Ram
 * @Since: 2020.10.21 14:42
 */
public interface TopFavoriteService {
    /**
     * 获取收藏排行榜的数据
     *
     * @param title 标题
     * @param minPrice 最低价格
     * @param maxPrice 最高价格
     * @param currentPage 当前页
     * @return 每页展示的数据
     */
    FavoriteData getTopList(String title, String minPrice, String maxPrice, String currentPage);
}
