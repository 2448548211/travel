package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.IFavoriteDao;
import com.xlibaba.travel.dao.IRouteDao;
import com.xlibaba.travel.dao.IUserDao;
import com.xlibaba.travel.dao.impl.FavoriteDaoImpl;
import com.xlibaba.travel.dao.impl.RouteDaoImpl;
import com.xlibaba.travel.dao.impl.UserDaoImpl;
import com.xlibaba.travel.entity.Favorite;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.entity.User;
import com.xlibaba.travel.service.IFavoriteService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: travel
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-10-21 20:16
 **/
public class FavoriteServiceImpl implements IFavoriteService {

    //dao
    IFavoriteDao dao = new FavoriteDaoImpl();

    @Override
    public int saveFavorite(String rid, String username) {
        //查询用户数据
        IUserDao userDao = new UserDaoImpl();
        User user = userDao.getUserByName(username);
        //查询路线数据
        IRouteDao routeDao = new RouteDaoImpl();
        Route route = routeDao.selectRouteById(Integer.parseInt(rid));

        //时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //收藏赋值
        Favorite favorite = new Favorite();
        favorite.setRid(route.getRid());
        favorite.setDate(sdf.format(new Date()));
        favorite.setUid(user.getUid());

        //加入数据库,并返回影响行数
        return dao.insertFavorite(favorite);
    }
}
