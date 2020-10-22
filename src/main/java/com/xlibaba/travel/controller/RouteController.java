package com.xlibaba.travel.controller;

import com.xlibaba.travel.entity.BaseResponseEntity;
import com.xlibaba.travel.entity.Page;
import com.xlibaba.travel.entity.Route;
import com.xlibaba.travel.service.IRouteService;
import com.xlibaba.travel.service.impl.RouteServiceImpl;
import com.xlibaba.travel.util.myutils.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RouteController")
public class RouteController extends HttpServlet {
    private IRouteService iRouteService = new RouteServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "list":
                toList(request,response);
                break;
            case "detail":
                toDetail(request,response);
                break;
        }

    }

    private void toDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        BaseResponseEntity re = null;
        Route route = iRouteService.selectRouteById(Integer.parseInt(id));
        try {
            re = BaseResponseEntity.success(route);
        } catch (Exception e) {
            re = BaseResponseEntity.error();
        }
        ResponseUtil.sendJSON(response,re);
    }

    private void toList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String routeName = request.getParameter("routeName");
        String currentPage = request.getParameter("currentPage");
        BaseResponseEntity re = null;
        Page page = iRouteService.selectRoutesByName(routeName, Integer.parseInt(currentPage));
        try {
            re = BaseResponseEntity.success(page);
        } catch (Exception e) {
            re = BaseResponseEntity.error();
        }
        ResponseUtil.sendJSON(response,re);
    }
}
