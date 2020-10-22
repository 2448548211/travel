package com.xlibaba.travel.controller;

import com.xlibaba.travel.entity.BaseResponseEntity;
import com.xlibaba.travel.entity.FavoriteData;
import com.xlibaba.travel.service.TopFavoriteService;
import com.xlibaba.travel.service.impl.TopFavoriteServiceImpl;
import com.xlibaba.travel.utils.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Ram
 * @Since: 2020.10.21 14:50
 */
@WebServlet("/topAll")
public class TopFavoriteController extends HttpServlet {
    private final TopFavoriteService service = new TopFavoriteServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前页
        String currentPage = req.getParameter("page");

        BaseResponseEntity<FavoriteData> responseEntity = null;
        try {
            FavoriteData data = service.getTopList(currentPage);
            //存放数据
            responseEntity = BaseResponseEntity.success(data);
        } catch (Exception e){
            responseEntity = BaseResponseEntity.error();
        }
        //响应
        ResponseUtil.sendJson(resp,responseEntity);
    }
}
