package com.example.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @create 2021-12-22 19:13
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决post请求中文乱码问题，一定要在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");
//        if("login".equals(action)){     //获取页面传递过来的隐藏域
//            login(req, resp);         //调用匹配的方法
//        }else if("regist".equals(action)){
//            regist(req, resp);
//        }
        //解决响应中文乱码问题
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");

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
            /*
             * 若在后面的代码中出了异常，之后的提交和回滚事务不能捕获到此异常
             * 事务捕获不到异常，不能有效的回滚。
             * 所以在父类代码中，有异常，一定要往外抛！
             */
            e.printStackTrace();
            throw new RuntimeException(); //把异常抛给Filter过滤器
        }
    }
}
