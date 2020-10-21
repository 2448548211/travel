package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.IFavoriteDao;
import com.xlibaba.travel.dao.IUserDao;
import com.xlibaba.travel.dao.impl.FavoriteDaoImpl;
import com.xlibaba.travel.dao.impl.UserDaoImpl;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.service.IMyFavoriteService;
import com.xlibaba.travel.service.page.MyFavoritePage;

import java.util.List;

/**
 * @author ChenWang
 * @className MyFavoriteServiceImpl
 * @date 2020/10/21 20:19
 * @since JDK 1.8
 */
public class MyFavoriteServiceImpl implements IMyFavoriteService {
    private IUserDao userDao = new UserDaoImpl();
    private IFavoriteDao favoriteDao = new FavoriteDaoImpl();
    @Override
    public MyFavoritePage getMyFavoritePage(String username) {
        MyFavoritePage myFavoritePage = new MyFavoritePage();
        myFavoritePage.setRoutes(favoriteDao.getListById(getIdByName(username)));
        return null;
    }
    @Override
    public Integer getIdByName(String username){
        return userDao.getIdByName(username);
    }

}
