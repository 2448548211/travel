package com.xlibaba.travel.dao.impl;

import com.xlibaba.travel.dao.TopFavoriteDao;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.util.utils.DbManager;

import java.util.List;

/**
 * @Author: Ram
 * @Since: 2020.10.21 11:33
 */
public class TopFavoriteDaoImpl implements TopFavoriteDao {

    @Override
    public List<Route> selectFavoriteAll(int offset, int pageSize) {
        String sql = "select rid,rname,price,count,rimage,sid FROM tab_route" +
                " WHERE is_del=1 order by count desc limit "+offset+","+pageSize+"";
        return DbManager.selectSql(sql);
    }

    @Override
    public int selectTotalCount() {
        String sql = "select count(*) from tab_route where is_del = 1";
        return DbManager.getTotalCount(sql);
    }

    @Override
    public List<Route> selectTopFavoriteByCondition(String title,double minPrice,double maxPrice,int offset, int pageSize) {
        String sql = "select rid,rname,price,count,rimage,sid FROM tab_route WHERE is_del=1 " +
                "and rname like '%"+title+"%' and price>="+minPrice+" and price<="+maxPrice+" " +
                "order by count desc limit "+offset+","+pageSize+"";
        return DbManager.selectSql(sql);
    }

    @Override
    public int selectTotalCount(String title, double minPrice, double maxPrice) {
        String sql = "select count(*) from tab_route where is_del = 1 and " +
                "rname like '%"+title+"%' and price>="+minPrice+" and price<="+maxPrice+"";
        return DbManager.getTotalCount(sql);
    }
}
