package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.IRouteDao;
import com.xlibaba.travel.dao.IRouteImgDao;
import com.xlibaba.travel.dao.impl.RouteDaoImpl;
import com.xlibaba.travel.dao.impl.RouteImgDaoImpl;
import com.xlibaba.travel.entity.RouteImg;
import com.xlibaba.travel.service.IDetailService;
import com.xlibaba.travel.service.entity.Detail;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: travel
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-10-21 14:29
 **/
public class DetailServiceImpl implements IDetailService {

    private IRouteImgDao imgDao = new RouteImgDaoImpl();
    private IRouteDao routeDao = new RouteDaoImpl();

    @Override
    public Detail getDetailImgById(int id) {
        Detail detail = new Detail();
        //获取图片地址
        List<RouteImg> routeImgs = imgDao.selectRouteImgById(id);
        List<String> imgList = new ArrayList<>();
        for (RouteImg rig : routeImgs) {
            imgList.add(rig.getBigPic());
        }
        //详细信息
        detail.setRoute(routeDao.selectRouteById(id));
        //图片信息
        detail.setRouteImgList(imgList);
        return detail;
    }
}
