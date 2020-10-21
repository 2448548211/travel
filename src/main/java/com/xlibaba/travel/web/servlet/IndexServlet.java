package com.xlibaba.travel.web.servlet;

import com.xlibaba.travel.entity.BaseResponseEntity;
import com.xlibaba.travel.service.IIndexService;
import com.xlibaba.travel.service.impl.IndexServiceImpl;
import com.xlibaba.travel.service.page.IndexPage;
import com.xlibaba.travel.util.myutils.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChenWang
 * @className IndexServlet
 * @date 2020/10/21 10:07
 * @since JDK 1.8
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    IIndexService indexService = new IndexServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IndexPage indexPage = null;
        indexPage = indexService.getIndexPage();
        BaseResponseEntity<IndexPage> myPackage = null;
        if(indexPage!=null){
            myPackage = BaseResponseEntity.success(indexPage);
        }else{
            myPackage = BaseResponseEntity.error();
        }
        ResponseUtil.sendJSON(resp,myPackage);
    }
}
