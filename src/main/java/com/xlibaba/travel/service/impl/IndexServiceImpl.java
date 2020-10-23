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
//首页数据获取
public class IndexServiceImpl implements IIndexService {
    private IRouteDao routeDao = new RouteDaoImpl();
    /**
     * 获取首页数据 -- 千峰精选导航页，国内页，国外页
     * @return      首页数据包括
     * @author ChenWang
     * @date 2020/10/23 14:18
     */
    @Override
    public IndexPage getIndexPage() {
        IndexPage indexPage = new IndexPage();
        indexPage.setTop(getIndexTopPage());
        indexPage.setMid(routeDao.getDomestic());
        indexPage.setFoot(routeDao.getAbroad());
        return indexPage;
    }
    /**
     * 获取千峰精选导航
     * @return  IndexTopPage
     * @author ChenWang
     * @date 2020/10/23 14:22
     */
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
