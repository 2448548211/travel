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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //创建数据包对象
        BaseResponseEntity<Integer> entity = null;
        //操作类型
        String action = req.getParameter("action");
        System.out.println(action);
        switch (action) {
            case "add": //添加
                entity = getAdd(req);
                break;
            case "del": //删除
                break;
            case "listDel": //批量删除
                break;
            default:
                break;
        }

        ResponseUtil.sendJSON(resp,entity);
    }

    //添加
    private BaseResponseEntity<Integer> getAdd(HttpServletRequest req) {
        BaseResponseEntity<Integer> entity;//获取前端数据
        String username = req.getParameter("username");
        String rid = req.getParameter("rid");

        int line = service.saveFavorite(rid, username);

        try {
            entity = BaseResponseEntity.success(line);
        } catch (Exception e) {
            entity = BaseResponseEntity.error(404,"网络错误");
        }
        return entity;
    }
}
