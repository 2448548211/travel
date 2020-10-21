package com.xlibaba.travel.service.impl;

import com.xlibaba.travel.dao.IRouteDao;
import com.xlibaba.travel.dao.impl.RouteDaoImpl;
import com.xlibaba.travel.entity.Page;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.service.IRouteService;

import java.util.List;

public class RouteServiceImpl implements IRouteService {
    private IRouteDao iRouteDao = new RouteDaoImpl();

    @Override
    public Page selectRoutesByName(String routeName, int currentPage) {
        Page page = new Page();
        page.setCurrentPage(currentPage);
        page.setSum(getSum(routeName));
        List<Route> routes = iRouteDao.selectRoutesByName(routeName, (currentPage - 1) * page.getPageSize(), page.getPageSize());
        page.setList(routes);
        return page;
    }

    @Override
    public Route selectRouteById(int id) {
        return iRouteDao.selectRouteById(id);
    }

    @Override
    public int getSum(String routeName) {
        if (routeName == null || routeName.equals("")) {
            return iRouteDao.getSum();
        }
        return iRouteDao.getSumByName(routeName);
    }
}
