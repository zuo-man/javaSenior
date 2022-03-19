package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 通过反射调用指定方法
 * @create 2021-12-22 19:13
 */
public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        // 一定要在获取请求参数调用之前才有效
        req.setCharacterEncoding("UTF-8");
        //解决相应中文乱码问题
        resp.setContentType("text/html; charset=UTF-8");

        //通过反射获取action传递过来的信息，并调用方法
        try {
            //1.获取action业务鉴别字符串，获取相应的业务 方法反射对象
            //this.getClass():获取当前类、getDeclaredMethod："action"表示获取指定的某个方法、参数 ：指明获取的方法的名称
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);

            //调用目标业务 方法
            //2.调用方法的invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
            //invoke()的返回值即为对应类中调用的方法的返回值。
            method.invoke(this, req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
