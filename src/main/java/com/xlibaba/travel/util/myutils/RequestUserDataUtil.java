package com.xlibaba.travel.util.myutils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ChenWang
 * @className PageUserDataUtil
 * @date 2020/10/22 17:36
 * @since JDK 1.8
 */
public class RequestUserDataUtil {
    private static final String USERNAME = "username";
    /**
     * 通过cookies,session和json对象或者url后带键对值来获取用户的username
     * @param req       指定请求
     * @return String   返回用户名
     * @author ChenWang
     * @date 2020/10/22 17:40
     */
    public static String getUsernameFromAll(HttpServletRequest req){
        String username = getUsernameFromAuthority(req);
        if(null==username||"".equals(username)){
            username = req.getParameter(USERNAME);
        }
        return username;
    }
    /**
     * 通过cookies,session来获取用户的username，并且自动添加到session中
     * @param req       指定的请求
     * @return String   返回用户名
     * @author ChenWang
     * @date 2020/10/22 17:53
     */
    public static String getUsernameFromAuthority(HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
        HttpSession session = req.getSession();
        String username = null;
        if(cookies!=null){
            for (Cookie c:cookies){
                if(USERNAME.equals(c.getName())){
                    username = c.getValue().split("%26")[0];
                    session.setAttribute(USERNAME,username);
                }
            }
        }
        if(null==username||"".equals(username)){
            if(session!=null){
                username = (String)session.getAttribute(USERNAME);
            }
        }
        return username;
    }
}
