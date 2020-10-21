package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.IRouteDao;
import com.xlibaba.travel.dao.impl.RouteDaoImpl;
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
    private IRouteDao routeDao = new RouteDaoImpl();
    @Override
    public IndexPage getIndexPage() {
        IndexPage indexPage = new IndexPage();
        indexPage.setTop(getIndexTopPage());
        indexPage.setMid(routeDao.getDomestic());
        indexPage.setFoot(routeDao.getAbroad());
        return indexPage;
    }
    @Override
    public IndexTopPage getIndexTopPage(){
        IndexTopPage page = new IndexTopPage();
        page.setTopExpensive(routeDao.getExpensive());
        page.setTopHot(routeDao.getHot());
        page.setTopNew(routeDao.getNew());
        page.setTopTheme(routeDao.getTheme());
        return page;
    }
}
