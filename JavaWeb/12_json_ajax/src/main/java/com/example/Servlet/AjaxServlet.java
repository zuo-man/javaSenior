package com.example.Servlet;

import com.example.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @create 2022-01-11 14:37
 */
public class AjaxServlet extends BaseServlet{

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax请求");

        Person person = new Person(1,"小优");

        //Json格式字符串传回给客户端
        Gson gson = new Gson();
        String jsonString = gson.toJson(person);

        resp.getWriter().write(jsonString);
    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" jQueryAjax 方法调用 ");
        Person person = new Person(1,"小优");
        // json格式的字符串
        Gson gson = new Gson();
        String JsonString = gson.toJson(person);

        resp.getWriter().write(JsonString);
    }

    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" jQueryGet 方法调用 ");
        Person person = new Person(1,"小优");
        // json格式的字符串
        Gson gson = new Gson();
        String JsonString = gson.toJson(person);
        resp.getWriter().write(JsonString);
    }

    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" jQueryPost 方法调用 ");
        Person person = new Person(1,"小优");
        // json格式的字符串
        Gson gson = new Gson();
        String JsonString = gson.toJson(person);
        resp.getWriter().write(JsonString);
    }

    protected void jQueryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" jQueryGetJSON 方法调用 ");
        Person person = new Person(1,"小优");
        // json格式的字符串
        Gson gson = new Gson();
        String JsonString = gson.toJson(person);
        resp.getWriter().write(JsonString);
    }

    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" jQuerySerialize 方法调用 ");

        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("密码：" + req.getParameter("password"));

        Person person = new Person(1,"小优");
        // json格式的字符串
        Gson gson = new Gson();
        String JsonString = gson.toJson(person);
        resp.getWriter().write(JsonString);
    }


}
