package com.xlibaba.travel.controller;

import com.xlibaba.travel.service.impl.TopFavoriteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  收藏页条件查询
 * @Author: Ram
 * @Since: 2020.10.21 15:31
 */
@WebServlet("/topCondition")
public class TopConditionController extends HttpServlet {
    private final TopFavoriteService service = new TopFavoriteServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取前端条件数据
        String title = req.getParameter("title");
        String minPrice = req.getParameter("minPrice");
        String maxPrice = req.getParameter("maxPrice");
        BaseResponseEntity<FavoriteData> responseEntity = null;
        try {
            //条件查询获取数据
            FavoriteData data = service.getTopListByCondition(title,minPrice,maxPrice);
            //数据存储
            responseEntity = BaseResponseEntity.success(data);
        } catch (Exception e){
            responseEntity = BaseResponseEntity.error();
        }
        ResponseUtil.sendJson(resp,responseEntity);
    }
}
