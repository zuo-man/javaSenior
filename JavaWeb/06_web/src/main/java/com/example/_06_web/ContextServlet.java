package com.example._06_web; /**
 * @create 2021-12-10 9:38
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.text.html.CSS;
import java.io.IOException;
import java.io.OutputStream;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取web.xml中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();//获取context对象

        String username = context.getInitParameter("username");
        System.out.println("context-param参数suername的值是：" + username);//输出的是context username对应的value值
        System.out.println("context-param参数password的值的：" + context.getInitParameter("password"));

        //2.获取当前的工程路径，格式：/工程路径
        System.out.println("当前工程路径：" + context.getContextPath());
        //3.获取工程部署在服务器硬盘上的绝对路径
        /*
        / 斜杠被服务器解析地址为：http://ip:port/工程名/  映射到IDEA的web目录
         */
        System.out.println("工程部署的路径是：" + context.getRealPath("/"));
        System.out.println("工程下css目录的绝对路径是：" + context.getRealPath("/css"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
