package com.xlibaba.travel.controller;

import com.xlibaba.travel.entity.BaseResponseEntity;
import com.xlibaba.travel.entity.User;
import com.xlibaba.travel.service.ILoginService;
import com.xlibaba.travel.service.impl.LoginServiceImpl;
import com.xlibaba.travel.util.myutils.ResponseUtil;

import javax.mail.Session;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @program: ayys-project
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-10-19 16:52
 **/
@WebServlet("/login")
public class LoginController extends HttpServlet {

    ILoginService service = new LoginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        //创建数据包对象
        BaseResponseEntity<Boolean> entity = null;

        //获取前端发送的的数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code"); //验证码
        System.out.println(username+"   "+password+"    "+code);

        //获取存放在 seesion 作用域中的验证码
        String serverCode = (String) req.getSession().getAttribute("CHECKCODE_SERVER");
        //验证码效验
        if (!serverCode.equals(code)) {
            entity = entity.error(401,"验证码有误");
            ResponseUtil.sendJSON(resp,entity);
            return;
        }

        //获取用户数据
        User user = service.getUserByName(username);
        //用户名验证
        if (user != null) {
            //密码验证
            if (password.equals(user.getPassword())) {
                //验证成功
                String cookieValue = username+"&"+password;
                //判断是否勾选保存
                String remember = req.getParameter("remember");
                if (remember.equals("yes")) {
                    cookieValue = cookieValue.concat("&"+remember);
                }
                //设置 cookie
                Cookie cookie = new Cookie("username", URLEncoder.encode(cookieValue, "utf-8"));
                cookie.setMaxAge(60*60*24);//设置时间(单位为秒)
                resp.addCookie(cookie);//添加cookie

                //记录登录凭证 -- 在 session 中存储用户名
                req.getSession().setAttribute("username",username);
                entity = entity.success(true);
            } else {
                entity = entity.error(403,"密码错误");
            }
        } else {
            entity = entity.error(402,"用户名不存在");
        }
        //返回数据给前端
        ResponseUtil.sendJSON(resp,entity);
    }
}
