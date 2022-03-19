package com.example._07_servlet; /**
 * @create 2021-12-11 13:21
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        i.getRequestURI()					获取请求的资源路径
        System.out.println("URI => " + request.getRequestURI());
//        ii.getRequestURL()					获取请求的统一资源定位符（绝对路径）
        System.out.println("URL => " + request.getRequestURL());
//        iii.getRemoteHost()				获取客户端的ip地址
        /**
         * 在IDEA中，使用localhost访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1<br/>
         * 在IDEA中，使用127.0.0.1访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1<br/>
         * 在IDEA中，使用 真实ip 访问时，得到的客户端 ip 地址是 ===>>> 真实的客户端 ip 地址<br/>
         */
        System.out.println("客户端 ip地址 => " + request.getRemoteHost());
//        iv.getHeader()						获取请求头
        System.out.println("请求头User-Agent ==>> " + request.getHeader("User-Agent"));
//        vii.getMethod()					获取请求的方式GET或POST
        System.out.println( "请求的方式 ==>> " + request.getMethod() );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
