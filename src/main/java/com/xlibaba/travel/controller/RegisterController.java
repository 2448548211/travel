package com.xlibaba.travel.controller;

import com.xlibaba.travel.entity.BaseResponseEntity;
import com.xlibaba.travel.entity.User;
import com.xlibaba.travel.service.IRegisterService;
import com.xlibaba.travel.service.impl.RegisterService;
import com.xlibaba.travel.util.myutils.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenxiaosong
 */

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    IRegisterService service = new RegisterService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        //创建数据包对象
        BaseResponseEntity<Boolean> entity = null;
        //获取前端发送的数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        /*String birthday = req.getParameter("birthday");
        String sex = req.getParameter("sex");*/
        String telephone = req.getParameter("telephone");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        User user = new User();
        //获取存放在session作用域中的验证码
        String serverCode = (String) req.getSession().getAttribute("CHECKCODE_SERVER");
        if (!serverCode.equals(code)){
            entity = BaseResponseEntity.error(401, "验证码有误！");
            ResponseUtil.sendJSON(resp,entity);
        }
        // 用户存在为 1，不存在为 0
        int i = service.checkUserName(username);
        if (i == 0){
            user.setUsername(username);
            user.setPassword(password);
            user.setName(name);
            /*user.setBirthday(birthday);
            user.setSex(sex);*/
            user.setTelephone(telephone);
            user.setEmail(email);
            service.insertUser(user);
            entity = BaseResponseEntity.success(200,"注册成功",true);
            ResponseUtil.sendJSON(resp, entity);
        }else {
            entity = BaseResponseEntity.error(400,"用户名已存在");
            //返回数据给前端
            ResponseUtil.sendJSON(resp, entity);
        }
    }
}
