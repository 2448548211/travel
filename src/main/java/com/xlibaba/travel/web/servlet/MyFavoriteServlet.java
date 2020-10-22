package com.xlibaba.travel.web.servlet;

import com.xlibaba.travel.entity.BaseResponseEntity;
import com.xlibaba.travel.service.IMyFavoriteService;
import com.xlibaba.travel.service.impl.MyFavoriteServiceImpl;
import com.xlibaba.travel.service.page.MyFavoritePage;
import com.xlibaba.travel.util.myutils.RequestUserDataUtil;
import com.xlibaba.travel.util.myutils.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebEndpoint;
import java.io.IOException;

/**
 * @author ChenWang
 * @className MyFavorite
 * @date 2020/10/21 20:16
 * @since JDK 1.8
 */
@WebServlet("/myFavorite")
public class MyFavoriteServlet extends HttpServlet {
    private IMyFavoriteService myFavoriteService = new MyFavoriteServiceImpl();
    private static final Integer ONE = 1;
    private static final String CURRENT_PAGE = "currentPage";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = RequestUserDataUtil.getUsernameFromAuthority(req);
        //String username = "zs";
        String cp = req.getParameter(CURRENT_PAGE);
        Integer currentPage = cp==null||"".equals(cp)?ONE:Integer.parseInt(req.getParameter(CURRENT_PAGE));
        MyFavoritePage myFavoritePage = myFavoriteService.getMyFavoritePage(username,currentPage);
        BaseResponseEntity<MyFavoritePage> pakage = null;
        if(myFavoritePage!=null){
            pakage = BaseResponseEntity.success(myFavoritePage);
        }else{
            pakage = BaseResponseEntity.error();
        }
        ResponseUtil.sendJSON(resp,pakage);
    }
}
