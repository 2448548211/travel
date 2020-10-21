package com.xlibaba.travel.dao;

import com.xlibaba.travel.entity.Route;

import java.util.List;

/**
 * @author ChenWang
 * @interfaceName IFavoriteDao
 * @date 2020/10/21 20:42
 * @since JDK 1.8
 */
public interface IFavoriteDao {

    List<Route> getListById(Integer id, int pageId, int pageSize);

    int getTotalCount(Integer id);
}
