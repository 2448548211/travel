package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.IFavoriteDao;
import com.xlibaba.travel.dao.IUserDao;
import com.xlibaba.travel.dao.impl.FavoriteDaoImpl;
import com.xlibaba.travel.dao.impl.UserDaoImpl;
import com.xlibaba.travel.service.IMyFavoriteService;
import com.xlibaba.travel.service.page.MyFavoritePage;

/**
 * @author ChenWang
 * @className MyFavoriteServiceImpl
 * @date 2020/10/21 20:19
 * @since JDK 1.8
 */
public class MyFavoriteServiceImpl implements IMyFavoriteService {
    private IUserDao userDao = new UserDaoImpl();
    private IFavoriteDao favoriteDao = new FavoriteDaoImpl();
    private static final Integer PAGE_SIZE = 12;
    /**
     * 根据用户名和页码获取对应的我的收藏页面数据
     * @param username          指定的用户名
	 * @param currentPage       指定的页码
     * @return MyFavoritePage   我的收藏页面
     * @author ChenWang
     * @date 2020/10/23 14:48
     */
    @Override
    public MyFavoritePage getMyFavoritePage(String username, Integer currentPage) {
        MyFavoritePage myFavoritePage = new MyFavoritePage();
        myFavoritePage.setCurrentPage(currentPage);
        Integer id = getIdByName(username);
        //每页条数
        myFavoritePage.setPageSize(PAGE_SIZE);
        //总条数设置的同时总页数自动设置--因为页面大小已经确定
        myFavoritePage.setTotalCount(favoriteDao.getTotalCount(id));
        myFavoritePage.setRoutes(favoriteDao.getListById(id,currentPage,PAGE_SIZE));
        return myFavoritePage;
    }
    /**
     * 根据名字获取ID
     * @param username  指定的用户名
     * @return  Integer ID
     * @author ChenWang
     * @date 2020/10/23 14:49
     */
    @Override
    public Integer getIdByName(String username){
        return userDao.getIdByName(username);
    }

}
