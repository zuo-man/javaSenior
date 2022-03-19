package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @create 2022-01-08 20:13
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决响应乱码
        resp.setContentType("text/html; charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if("123".equals(username) && "123".equals(password)){
            req.getSession().setAttribute("user",username);
            resp.getWriter().write("登录成功");
        }else {
            //登录失败，返回界面
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
