package com.xlibaba.travel.service;

public interface IFavoriteService {

    //添加收藏
    boolean saveFavorite(String rid, String username);
}
