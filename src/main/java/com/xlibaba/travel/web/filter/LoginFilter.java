package com.xlibaba.travel.web.filter;

import com.xlibaba.travel.util.myutils.RequestUserDataUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import java.io.IOException;

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
        /*转换请求和响应类型*/
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        /*从cookie和session中获取username*/
        String username = RequestUserDataUtil.getUsernameFromAuthority(req);
        /*获取请求的路径*/
        String requestURI = req.getRequestURI();
        boolean flag = /*requestURI.endsWith("index.html") ||requestURI.endsWith("index")||
                requestURI.endsWith("login.html") ||requestURI.endsWith("login")||
                requestURI.endsWith("register.html") ||requestURI.endsWith("register")||
                username != null;*/
                (requestURI.endsWith("myfavorite.html")&&username!=null) ||(requestURI.endsWith("myFavorite")&&username!=null)
                        ||  (requestURI.endsWith("favorite")&&username!=null)
                        || !requestURI.endsWith("myfavorite.html");
        /*判定路径是否合理*/
        if (flag) {
            /*合理放行*/
            filterChain.doFilter(request, response);
        } else {
            /*跳回首页*/
            resp.sendRedirect("index.html");
        }
    }
}
