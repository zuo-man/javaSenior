package com.example._07_servlet; /**
 * @create 2021-12-11 15:19
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RespinseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        System.out.println( resp.getCharacterEncoding() );//默认ISO-8859-1 ，不支持中文

//        // 设置服务器字符集为UTF-8
//        resp.setCharacterEncoding("UTF-8");
//        // 通过响应头，设置浏览器也使用UTF-8字符集
//        resp.setHeader("Content-Type", "text/html; charset=UTF-8");

        // 它会同时设置服务器和客户端都使用UTF-8字符集，还设置了响应头
        // 此方法一定要在获取流对象之前调用才有效
        response.setContentType("text/html; charset=UTF-8");

//        System.out.println( resp.getCharacterEncoding() );

        //要求：往客户端回传 字符串数据
        PrintWriter w = response.getWriter();
        w.write("yes ♂ 男");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
