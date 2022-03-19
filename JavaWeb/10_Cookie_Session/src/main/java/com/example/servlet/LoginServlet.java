package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @create 2022-01-02 18:20
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if("123".equals(username) && "123".equals(password)){
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24);  //当前Cookie一周内有效
            resp.addCookie(cookie);
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}
