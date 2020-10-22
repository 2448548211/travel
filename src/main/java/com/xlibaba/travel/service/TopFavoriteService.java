package com.xlibaba.travel.service;

import com.xlibaba.travel.entity.FavoriteData;

/**
 * @Author: Ram
 * @Since: 2020.10.21 14:42
 */
public interface TopFavoriteService {
    /**
     * 获取收藏排行榜的数据
     * @param currentPage 当前页
     * @return 每页展示的数据
     */
    FavoriteData getTopList(String currentPage);

    /**
     * 条件查询获取数据
     * @param title 路线名称
     * @param minPrice 最低价格
     * @param maxPrice 最高价格
     * @return 数据集合
     */
    FavoriteData getTopListByCondition(String title,String minPrice,String maxPrice,String page);

}
