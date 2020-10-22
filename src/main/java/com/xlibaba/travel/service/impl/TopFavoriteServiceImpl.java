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

    @Override
    public FavoriteData getTopList(String currentPage) {
        FavoriteData topCollectionData = new FavoriteData();
        //1.设置当前页
        topCollectionData.setCurrentPage(Integer.parseInt(currentPage));
        //2.设置每页展示的数据
        topCollectionData.setPageSize(8);
        //3.设置总条数
        topCollectionData.setTotalCount(topFavoriteDao.selectTotalCount());
        //4.设置总页数 -- 在 FavoriteData 对象中通过算法完成

        //5.设置每页展示的数据行
        topCollectionData.setList(topFavoriteDao.selectFavoriteAll((Integer.parseInt(currentPage)-1)*topCollectionData.getPageSize(), topCollectionData.getPageSize()));

        return topCollectionData;
    }

    /**
     *  条件搜索
     * @param title 路线名称
     * @param minPrice 最低价格
     * @param maxPrice 最高价格
     * @return 数据对象
     */
    @Override
    public FavoriteData getTopListByCondition(String title,String minPrice,String maxPrice) {
        List<Route> list = topFavoriteDao.selectTopFavoriteByCondition
                (title, Integer.parseInt(minPrice), Integer.parseInt(maxPrice));
        FavoriteData data = new FavoriteData();
        data.setList(list);
        return data;
    }

}
