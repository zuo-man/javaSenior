package com.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @create 2022-01-09 19:32
 */
public class ManagerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //先得到Session、类型转换
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        Object user = httpServletRequest.getSession().getAttribute("user");

        if (user == null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }else {
            //放行
            chain.doFilter(request, response);
        }
    }
}
