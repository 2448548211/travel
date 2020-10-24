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
    public FavoriteData getTopList
            (String title, String minPrice, String maxPrice, String currentPage) {
        //1.设置当前页
        data.setCurrentPage(Integer.parseInt(currentPage));
        //2.设置每页展示的数据条数
        data.setPageSize(8);
        //3.设置总条数
        data.setTotalCount(topFavoriteDao.selectTotalCount(title,minPrice,maxPrice));
        //获取每页展示的数据
        List<Route> topFavoriteData = topFavoriteDao.selectFavoriteAll(title, minPrice, maxPrice,
                (Integer.parseInt(currentPage) - 1) * data.getPageSize(), data.getPageSize());
        //5.设置每页展示的数据行
        data.setList(topFavoriteData);
        //返回数据对象
        return data;
    }
}
