package com.example._07_servlet; /**
 * @create 2021-12-11 15:37
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

//请求重定向
public class Respense1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("response 1 到此一游");

        req.setAttribute("key1","value1");

        //设置相应状态码302， 表示重定向，（已搬迁）
//        resp.setStatus(302);
        //设置响应头，说明 新的地址在哪里  (location: 位置)
//        resp.setHeader("Location","http://localhost:8080/07_servlet/e2");

        //方式二:
        resp.sendRedirect("http://localhost:8080/07_servlet/e2");
    }
}
