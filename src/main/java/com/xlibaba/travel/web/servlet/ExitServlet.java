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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie c:cookies){

        }
        HttpSession session = req.getSession();
        //第一种时长
        //session.setMaxInactiveInterval(0);
        //第二种让session失效的方法
        session.invalidate();
        //第三种
        //session.removeAttribute("username");

        resp.sendRedirect(req.getContextPath()+"/index.html");
    }
}
