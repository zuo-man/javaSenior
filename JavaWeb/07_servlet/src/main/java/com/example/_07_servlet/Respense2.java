package com.example._07_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @create 2021-12-11 15:38
 */
public class Respense2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getAttribute("key1")); //不共享Request域中的数据

        resp.getWriter().write(" response2 ");//往客户端回传 字符串数据
    }
}
