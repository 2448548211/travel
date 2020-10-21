package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.ICategoryDAO;
import com.xlibaba.travel.dao.impl.CategoryDAOImpl;
import com.xlibaba.travel.service.IHeaderService;
import com.xlibaba.travel.service.page.HeaderPage;

import java.awt.*;

/**
 * @author ChenWang
 * @className HeaderServiceImpl
 * @date 2020/10/20 23:01
 * @since JDK 1.8
 */
public class HeaderServiceImpl implements IHeaderService {
    private ICategoryDAO categoryDAO = new CategoryDAOImpl();
    @Override
    public HeaderPage getHeaderPage(String username) {
        HeaderPage headerPage = new HeaderPage();
        headerPage.setUsername(username);
        headerPage.setNavBar(categoryDAO.selectAll());
        return headerPage;
    }
}
