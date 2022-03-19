package com.example._06_web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @create 2021-12-08 19:02
 */
public class Hello implements Servlet{
    /**
     * service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service === hello Servlet 被访问了");

        //类型转换(因为有getMethod()方法)
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        //获取请求方式
        String method = httpServletRequest.getMethod();

        if("GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }
    }
    public void doGet(){
        System.out.println("get请求");
        System.out.println("get请求");
    }
    public void doPost(){
        System.out.println("post请求");
        System.out.println("post请求");
    }



    public Hello() {
        System.out.println("1.构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2. init初始化方法");

        //1.可以获取Servlet程序的别名servlet-name的值
        System.out.println("Hello程序的别名是：" + servletConfig.getServletName());
        //2.获取初始化参数init-param
        System.out.println("初始化参数username的值的：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值的：" + servletConfig.getInitParameter("url"));
        //3.获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }



    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4. desroy销毁方法");
    }
}


