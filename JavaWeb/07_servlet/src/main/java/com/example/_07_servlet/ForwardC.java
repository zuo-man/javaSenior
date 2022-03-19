package com.example._07_servlet; /**
 * @create 2021-12-11 14:23
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ForwardC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("经过了ForwardC程序");
        request.getRequestDispatcher("/a/b/c.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
