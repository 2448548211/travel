package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.IRouteDao;
import com.xlibaba.travel.dao.IRouteImgDao;
import com.xlibaba.travel.dao.IUserDao;
import com.xlibaba.travel.dao.impl.FavoriteDaoImpl;
import com.xlibaba.travel.dao.impl.RouteDaoImpl;
import com.xlibaba.travel.dao.impl.RouteImgDaoImpl;
import com.xlibaba.travel.dao.impl.UserDaoImpl;
import com.xlibaba.travel.entity.Favorite;
import com.xlibaba.travel.entity.RouteImg;
import com.xlibaba.travel.entity.User;
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

    /**
     * 通过ID获取路线详情    用户名用于获取收藏状态
     * @param id            指定的路线ID
	 * @param username      指定的用户名
     * @return Detail       详情数据
     * @date 2020/10/23 14:56
     */
    @Override
    public Detail getDetailImgById(int id, String username) {
        Detail detail = new Detail();
        //获取图片地址
        List<RouteImg> routeImgs = imgDao.selectRouteImgById(id);
        List<String> imgList = new ArrayList<>();
        for (RouteImg rig : routeImgs) {
            imgList.add(rig.getBigPic());
        }
        //获取收藏状态,默认为-1（未登录）
        int state = -1 ;
        if (username != null) {
            state = getFavoriteStateByID(id, username);
        }

        //获取并设置详细信息
        detail.setRoute(routeDao.selectRouteById(id));
        //设置获取图片信息
        detail.setRouteImgList(imgList);
        //设置收藏状态
        detail.setFavoriteState(state);
        return detail;
    }

    //查询收藏状态,返回0为未收藏、1相反
    /**
     * 获取收藏状态
     * @param rid       指定的ID
	 * @param username  指定的用户名
     * @return  int     返回0表示没有收藏，返回1表示已经收藏
     * @author ChenWang
     * @date 2020/10/23 14:58
     */
    @Override
    public int getFavoriteStateByID(int rid, String username) {
        //查询用户数据
        IUserDao userDao = new UserDaoImpl();
        User user = userDao.getUserByName(username);
        //查询收藏数据
        Favorite favorite = new FavoriteDaoImpl().getFavorite(rid, user.getUid(),1);
        if (favorite == null) {
            return 0;
        }
        return 1;
    }
}
