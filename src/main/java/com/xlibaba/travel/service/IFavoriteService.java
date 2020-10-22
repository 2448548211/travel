package com.xlibaba.travel.service;

public interface IFavoriteService {

    //添加收藏
    int saveFavorite(String rid, String username);

    //删除收藏
    int deleteFavorite(String rid, String username);
}
