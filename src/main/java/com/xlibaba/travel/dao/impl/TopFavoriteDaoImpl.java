package com.xlibaba.travel.dao.impl;

/**
 * @Author: Ram
 * @Since: 2020.10.21 11:33
 */
public class TopFavoriteDaoImpl implements TopFavoriteDao {

    @Override
    public List<Route> selectFavoriteAll(int offset, int pageSize) {
        String sql = "select rid,rname,price,count,rimage,sid FROM tab_route" +
                " WHERE is_del=0 order by count desc limit "+offset+","+pageSize+"";
        return DbManager.selectSql(sql);
    }

    @Override
    public int selectTotalCount() {
        String sql = "select count(*) from tab_route where is_del = 0";
        return DbManager.getTotalCount(sql);
    }

    @Override
    public List<Route> selectTopFavoriteByCondition(String title,double minPrice, double maxPrice) {
        String sql = "select rid,rname,price,count,rimage,sid FROM tab_route WHERE is_del=0 " +
                "and rname like '%"+title+"%' and price>="+minPrice+" and price<="+maxPrice+" order by count desc";
        return DbManager.selectSql(sql);
    }
}
