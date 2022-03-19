package com.example.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @create 2022-01-09 15:08
 */
public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter2 前置代码");

        chain.doFilter(request, response);

        System.out.println("Filter2 后置代码");
    }
}
