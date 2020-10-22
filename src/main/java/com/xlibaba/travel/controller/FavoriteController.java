package com.xlibaba.travel.controller;

import com.xlibaba.travel.entity.BaseResponseEntity;
import com.xlibaba.travel.service.IFavoriteService;
import com.xlibaba.travel.service.entity.Detail;
import com.xlibaba.travel.service.impl.FavoriteServiceImpl;
import com.xlibaba.travel.util.myutils.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: travel
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-10-21 19:41
 **/
@WebServlet("/favorite")
public class FavoriteController extends HttpServlet {

    IFavoriteService service = new FavoriteServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建数据包对象
        BaseResponseEntity<Detail> entity = null;
        //获取前端数据
        String username = req.getParameter("username");
        String rid = req.getParameter("rid");

        service. saveFavorite(rid,username);

        try {
            entity = BaseResponseEntity.success(null);
        } catch (Exception e) {
            entity = BaseResponseEntity.error(404,"网络错误");
        }
        ResponseUtil.sendJSON(resp,entity);
    }
}
