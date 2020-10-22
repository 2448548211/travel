package com.xlibaba.travel.dao;

import com.xlibaba.travel.entity.Route;

import java.util.List;

/**
 * @Author: Ram
 * @Since: 2020.10.21 11:32
 */
public interface TopFavoriteDao {
    /**
     * 获取收藏排行榜的所有数据
     * @param offset 偏移量
     * @param pageSize 每页展示的数据
     * @return 数据结合
     */
    List<Route> selectFavoriteAll(int offset, int pageSize);

    /**
     * 获取数据总条数
     * @return 行数
     */
    int selectTotalCount();

    /**
     * 条件查询
     * @param title 标题
     * @param minPrice 最低价格
     * @param maxPrice 最高价格
     * @return 数据集合
     */
    List<Route> selectTopFavoriteByCondition(String title,double minPrice,double maxPrice);
}
