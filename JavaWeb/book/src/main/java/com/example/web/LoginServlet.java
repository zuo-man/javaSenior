package com.example.web;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 登录，已整合为UserServlet
 * @create 2021-12-14 9:24
 */
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//编辑传入mysql字符集，否则会乱码
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用 userService.login()登录处理业务
        User loginuser = userService.login(new User(null,username,password,null));
        //如果等于null，说明登录失败
        if(loginuser == null){
            //把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("error","用户名或密码错误");
            req.setAttribute("username",username);

            //跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            //跳转到登录成功页面
            req.getRequestDispatcher("//pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
