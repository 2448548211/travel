package com.xlibaba.travel.service;

import com.xlibaba.travel.entity.RouteImg;
import com.xlibaba.travel.service.entity.Detail;

import java.util.List;

public interface IDetailService {

    //以id查询数据
    public Detail getDetailImgById(int id, String username);

    //查询收藏状态
    int getFavoriteStateByID(int rid, String username);

}
