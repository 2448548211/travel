package com.xlibaba.travel.dao;

import com.xlibaba.travel.entity.Favorite;
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

    //添加收藏
    int insertFavorite(Favorite favorite);

    //通过rid和uid删除收藏
    int deleteFavorite(int rid, int uid);

    //通过rid和uid查询收藏表数据；del:0已删除的数据数据,1未已删除的数据数据
    Favorite getFavorite(int rid, int uid, int del);

    //恢复已删除的数据
    int restoreFavorite(int rid, int uid);

}
