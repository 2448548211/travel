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
    @Override
    public HeaderPage getHeaderPage(String username) {
        HeaderPage headerPage = new HeaderPage();
        headerPage.setUsername(username);
        headerPage.setNavBar(categoryDao.selectAll());
        return headerPage;
    }
}
