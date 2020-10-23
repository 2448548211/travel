package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.IRouteDao;
import com.xlibaba.travel.dao.impl.RouteDaoImpl;
import com.xlibaba.travel.entity.Page;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.service.IRouteService;

import java.util.List;

public class RouteServiceImpl implements IRouteService {
    private IRouteDao iRouteDao = new RouteDaoImpl();
    /**
     * 通过名字查询路线
     * @param routeName     路线名
	 * @param currentPage   当前页面
     * @return  Page        页面数据
     * @date 2020/10/23 14:44
     */
    @Override
    public Page selectRoutesByName(String routeName, int currentPage) {
        Page page = new Page();
        page.setCurrentPage(currentPage);
        List<Route> routes = iRouteDao.selectRoutesByName(routeName, (currentPage - 1) * page.getPageSize(), page.getPageSize());
        int size = routes.size();
        page.setSum(size);
        page.setList(routes);
        return page;
    }
    /**
     * 通过ID获取路线
     * @param id        指定的ID
     * @return  Route   路线
     * @date 2020/10/23 14:45
     */
    @Override
    public Route selectRouteById(int id) {
        return iRouteDao.selectRouteById(id);
    }
}
