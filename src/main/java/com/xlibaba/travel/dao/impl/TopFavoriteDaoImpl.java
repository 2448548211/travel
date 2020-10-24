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
    /**
     * 获取所有数据
     */
    public static final String BASE_SQL =
            "select rid,rname,price,count,rimage,sid FROM tab_route" +
                    " WHERE is_del=0";
    /**
     * 排序SQL
     */
    public static final String DESC_SQL = " order by count desc ";
    /**
     * 获取数据总条数
     */
    public static final String COUNT_SQL = "select count(*) from tab_route where is_del=0 ";


    @Override
    public List<Route> selectFavoriteAll(String title, String minPrice, String maxPrice, int offset, int pageSize) {
        StringBuffer sql = new StringBuffer(BASE_SQL);
        //如果都为空 -- 无条件查询所有数据
        if ("".equals(title) && "".equals(minPrice) && "".equals(maxPrice)) {
            sql.append(DESC_SQL).append("limit ").append(offset).append(",").append(pageSize);
            //如果标题和某一价格为空
        } else if ("".equals(title) && "".equals(minPrice)) {
            sql.append(" and ").append("price<=").append(Integer.parseInt(maxPrice))
                    .append(DESC_SQL).append("limit ").append(offset).append(",").append(pageSize);
        } else if ("".equals(title) && "".equals(maxPrice)) {
            sql.append(" and ").append("price>=").append(Integer.parseInt(minPrice))
                    .append(DESC_SQL).append("limit ").append(offset).append(",").append(pageSize);
            //如果价格为空
        } else if ("".equals(minPrice) && "".equals(maxPrice)) {
            sql.append(" and ").append("rname").append(" like ").append("'%").append(title)
                    .append("%'").append(DESC_SQL).append("limit ").append(offset).append(",").append(pageSize);
            //如果标题为空 -- 查询价格区间的数据
        } else if ("".equals(title)) {
            sql.append(" and ").append("price>=").append(Integer.parseInt(minPrice))
                    .append(" and ").append("price<=").append(Integer.parseInt(maxPrice))
                    .append(DESC_SQL).append("limit ").append(offset).append(",").append(pageSize);
            //如果价格为空
        } else if ("".equals(minPrice)) {
            sql.append(" and ").append("rname").append(" like ").append("'%").append(title).append("%'")
                    .append(" and ").append("price<=").append(Integer.parseInt(maxPrice))
                    .append(DESC_SQL).append("limit ").append(offset).append(",").append(pageSize);
        } else if ("".equals(maxPrice)) {
            sql.append(" and ").append("rname").append(" like ").append("'%").append(title).append("%'")
                    .append(" and ").append("price>=").append(Integer.parseInt(minPrice))
                    .append(DESC_SQL).append("limit ").append(offset).append(",").append(pageSize);
        } else {
            sql.append(" and ").append("rname").append(" like ")
                    .append("'%").append(title).append("%'").append(" and ")
                    .append("price>=").append(Integer.parseInt(minPrice))
                    .append("price<=").append(Integer.parseInt(maxPrice))
                    .append(DESC_SQL).append("limit ").append(offset).append(",").append(pageSize);
        }
        return DbManager.selectSql(sql);
    }

    @Override
    public int selectTotalCount(String title, String minPrice, String maxPrice) {
        StringBuffer sql = new StringBuffer(COUNT_SQL);
        //如果都为空 -- 无条件查询所有数据
        if ("".equals(title) && "".equals(minPrice) && "".equals(maxPrice)) {
            System.out.println(123);
            //如果标题和某一价格为空
        } else if ("".equals(title) && "".equals(minPrice)) {
            sql.append("and ").append("price<=").append(Integer.parseInt(maxPrice));
        } else if ("".equals(title) && "".equals(maxPrice)) {
            sql.append("and ").append("price>=").append(Integer.parseInt(minPrice));
            //如果价格为空
        } else if ("".equals(minPrice) && "".equals(maxPrice)) {
            sql.append("and ").append("rname").append(" like ")
                    .append("'%").append(title).append("%'");
            //如果标题为空 -- 查询价格区间的数据
        } else if ("".equals(title)) {
            sql.append("and ").append("price>=").append(Integer.parseInt(minPrice))
                    .append(" and ").append("price<=").append(Integer.parseInt(maxPrice));
            //如果价格为空
        } else if ("".equals(minPrice)) {
            sql.append("and ").append("rname").append(" like ").append("'%").append(title).append("%'")
            .append(" and ").append("price<=").append(Integer.parseInt(maxPrice));
        } else if ("".equals(maxPrice)) {
            sql.append("and ").append("rname").append(" like ").append("'%").append(title).append("%'")
                    .append(" and ").append("price>=").append(Integer.parseInt(minPrice));
        } else {
            sql.append("and ").append("rname").append(" like ").append("'%").append(title).append("%'")
                    .append(" and ").append("price>=").append(Integer.parseInt(minPrice))
                    .append(" and ").append("price<=").append(Integer.parseInt(maxPrice));
        }
        return DbManager.getTotalCount(sql);
    }
}
