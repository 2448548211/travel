package com.xlibaba.travel.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * @author ChenWang
 * @className LoginFilter
 * @date 2020/10/22 11:18
 * @since JDK 1.8
 */
public class LoginFilter extends DefaultFilter {
    private static final String USERNAME = "username";
    /**
     * 过滤器，判定用户是否登录，根据权限放行对应的请求
     * @param request       指定请求
	 * @param response      指定响应
	 * @param filterChain   过滤器放行
     * @author ChenWang
     * @date 2020/10/22 11:36
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String username = null;
        Cookie[] cookies = req.getCookies();
        for (Cookie c:cookies){
            if(USERNAME.equals(c.getName())){
                username = c.getValue();
            }
        }
        if(null==username||"".equals(username)){
            HttpSession session = req.getSession();
            username = (String) session.getAttribute(USERNAME);
        }
        String requestURI = req.getRequestURI();
        boolean flag = requestURI.endsWith("index") || requestURI.endsWith("login") || requestURI.endsWith("register") || username != null;
        if (flag) {
            filterChain.doFilter(request, response);
        } else {
            resp.sendRedirect("index.html");
        }
    }
}
