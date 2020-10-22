package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.TopFavoriteDao;
import com.xlibaba.travel.dao.impl.TopFavoriteDaoImpl;
import com.xlibaba.travel.entity.FavoriteData;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.service.TopFavoriteService;

import java.util.List;

/**
 * @Author: Ram
 * @Since: 2020.10.21 14:44
 */
public class TopFavoriteServiceImpl implements TopFavoriteService {
    private final TopFavoriteDao topFavoriteDao = new TopFavoriteDaoImpl();
    private final FavoriteData data = new FavoriteData();

    @Override
    public FavoriteData getTopList(String currentPage) {
        //1.设置当前页
        data.setCurrentPage(Integer.parseInt(currentPage));
        //2.设置每页展示的数据
        data.setPageSize(8);
        //3.设置总条数
        data.setTotalCount(topFavoriteDao.selectTotalCount());

        //5.设置每页展示的数据行
        data.setList(topFavoriteDao.selectFavoriteAll(
                (Integer.parseInt(currentPage)-1)*data.getPageSize(), data.getPageSize()));
        //返回数据对象
        return data;
    }

    /**
     *  条件搜索
     * @param title 路线名称
     * @param minPrice 最低价格
     * @param maxPrice 最高价格
     * @return 数据对象
     */
    @Override
    public FavoriteData getTopListByCondition(String title,String minPrice,String maxPrice,String page) {
        //1.设置当前页
        data.setCurrentPage(Integer.parseInt(page));
        //2.设置每页展示的数据
        data.setPageSize(8);
        //设置总条数
        data.setTotalCount(topFavoriteDao.selectTotalCount
                (title, Integer.parseInt(minPrice), Integer.parseInt(maxPrice)));

        //条件获取数据
        List<Route> list = topFavoriteDao.selectTopFavoriteByCondition
                (title, Integer.parseInt(minPrice), Integer.parseInt(maxPrice),
                        (Integer.parseInt(page)-1)*data.getPageSize(), data.getPageSize());
        data.setList(list);

        return data;
    }

}
