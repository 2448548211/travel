package com.xlibaba.travel.dao;

import com.xlibaba.travel.entity.RouteImg;

import java.util.List;

public interface IRouteImgDao {

    //以id查询数据
    public List<RouteImg> selectRouteImgById(int id);


}
