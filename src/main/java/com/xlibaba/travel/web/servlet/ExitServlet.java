package com.xlibaba.travel.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author ChenWang
 * @className ExitServlet
 * @date 2020/10/21 10:00
 * @since JDK 1.8
 */
@WebServlet("/exit")
public class ExitServlet extends HttpServlet {
    private static final String USERNAME = "username";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*新建无效cookie覆盖原cookie*/
        Cookie cookie = new Cookie(USERNAME,"");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        /*注销session*/
        HttpSession session = req.getSession();
        /*第一种设置有效时间为0
        session.setMaxInactiveInterval(0);*/
        /*第二种让session失效的方法
        session.invalidate();*/
        /*第三种*/
        session.removeAttribute("username");
        /*resp.sendRedirect(req.getContextPath()+"/index.html");*/
        req.getRequestDispatcher("login.html").forward(req,resp);
    }
}
