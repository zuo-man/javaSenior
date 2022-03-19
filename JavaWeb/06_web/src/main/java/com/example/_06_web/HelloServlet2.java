package com.example._06_web; /**
 * @create 2021-12-08 20:52
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);   //重写了父类的方法，调用时是多态执行子类init方法，父类的重写代码数据会丢失，需要super
        System.out.println("重写了init初始化方法，做了一些工作");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("2  gethttp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("2  posthttp");
    }
}
