package com.xlibaba.travel.controller;

import com.xlibaba.travel.entity.BaseResponseEntity;
import com.xlibaba.travel.service.IDetailService;
import com.xlibaba.travel.service.entity.Detail;
import com.xlibaba.travel.service.impl.DetailServiceImpl;
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
 * @create: 2020-10-21 15:01
 **/
@WebServlet("/detail")
public class DetailController extends HttpServlet {

    IDetailService service = new DetailServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建数据包对象
        BaseResponseEntity<Detail> entity = null;
        String id = req.getParameter("id");
        Detail detail = service.getDetailImgById(Integer.parseInt(id));
        try {
            entity = BaseResponseEntity.success(detail);
        } catch (Exception e) {
            entity = BaseResponseEntity.error(404,"网络错误");
        }
        ResponseUtil.sendJSON(resp,entity);
    }
}
