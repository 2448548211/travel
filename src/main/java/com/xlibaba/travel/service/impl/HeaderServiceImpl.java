package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.ICategoryDao;
import com.xlibaba.travel.dao.impl.CategoryDaoImpl;
import com.xlibaba.travel.service.IHeaderService;
import com.xlibaba.travel.service.page.HeaderPage;

/**
 * @author ChenWang
 * @className HeaderServiceImpl
 * @date 2020/10/20 23:01
 * @since JDK 1.8
 */
public class HeaderServiceImpl implements IHeaderService {
    private ICategoryDao categoryDao = new CategoryDaoImpl();
    /**
     * 获取标头页面数据
     * @param username  用户数据
     * @return  HeaderPage  标头页面数据
     * @author ChenWang
     * @date 2020/10/23 14:52
     */
    @Override
    public HeaderPage getHeaderPage(String username) {
        HeaderPage headerPage = new HeaderPage();
        headerPage.setUsername(username);
        headerPage.setNavBar(categoryDao.selectAll());
        return headerPage;
    }
}
