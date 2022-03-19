package com.example._06_web;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    /**
     * doget（）在get请求时调用
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("gethttp");
    }

    /**
     * dopost（）在post请求时调用
     * @param request
     * @param response
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("posthttp");
    }

    public void destroy() {
    }
}