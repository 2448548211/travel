package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.IRouteDAO;
import com.xlibaba.travel.dao.impl.RouteDAOImpl;
import com.xlibaba.travel.service.IIndexService;
import com.xlibaba.travel.service.page.IndexPage;
import com.xlibaba.travel.service.page.IndexTopPage;

/**
 * @author ChenWang
 * @className IndexServiceImpl
 * @date 2020/10/21 10:14
 * @since JDK 1.8
 */
public class IndexServiceImpl implements IIndexService {
    private IRouteDAO routeDAO = new RouteDAOImpl();
    @Override
    public IndexPage getIndexPage() {
        IndexPage indexPage = new IndexPage();
        indexPage.setTop(getIndexTopPage());
        indexPage.setMid(routeDAO.getDomestic());
        indexPage.setFoot(routeDAO.getAbroad());
        return indexPage;
    }
    @Override
    public IndexTopPage getIndexTopPage(){
        IndexTopPage page = new IndexTopPage();
        page.setTopExpensive(routeDAO.getExpensive());
        page.setTopHot(routeDAO.getHot());
        page.setTopNew(routeDAO.getNew());
        page.setTopTheme(routeDAO.getTheme());
        return page;
    }
}
