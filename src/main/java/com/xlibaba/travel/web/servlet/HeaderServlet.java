package com.xlibaba.travel.web.servlet;

import com.xlibaba.travel.entity.BaseResponseEntity;
import com.xlibaba.travel.service.IHeaderService;
import com.xlibaba.travel.service.impl.HeaderServiceImpl;
import com.xlibaba.travel.service.page.HeaderPage;
import com.xlibaba.travel.util.myutils.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChenWang
 * @className HeaderServlet
 * @date 2020/10/20 22:23
 * @since JDK 1.8
 */
@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
    private IHeaderService headerService = new HeaderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        HeaderPage headerPage = headerService.getHeaderPage(username);
        BaseResponseEntity<HeaderPage> pakage = null;
        if(headerPage!=null){
            pakage = new BaseResponseEntity<HeaderPage>().success(headerPage);
        }else{
            pakage = new BaseResponseEntity<HeaderPage>().error();
        }
        ResponseUtil.sendJSON(resp,pakage);
    }
}
