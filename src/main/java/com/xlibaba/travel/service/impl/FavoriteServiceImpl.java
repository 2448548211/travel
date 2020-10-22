package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.IRouteDao;
import com.xlibaba.travel.dao.IUserDao;
import com.xlibaba.travel.dao.impl.RouteDaoImpl;
import com.xlibaba.travel.dao.impl.UserDaoImpl;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.entity.User;
import com.xlibaba.travel.service.IFavoriteService;

/**
 * @program: travel
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-10-21 20:16
 **/
public class FavoriteServiceImpl implements IFavoriteService {



    @Override
    public boolean saveFavorite(String rid, String username) {
        //查询用户
        IUserDao userDao = new UserDaoImpl();
        User user = userDao.getUserByName(username);
        //查询路线
        IRouteDao routeDao = new RouteDaoImpl();
        Route route = routeDao.selectRouteById(Integer.parseInt(rid));



        return true;
    }
}
