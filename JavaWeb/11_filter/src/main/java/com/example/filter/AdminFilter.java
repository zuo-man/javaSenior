package com.example.filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ServiceLoader;

/**
 * @create 2022-01-08 19:36
 */
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        //若等于null，说明还没有登录
        if(user == null){
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        }else {
            //让程序继续往下访问用户的目标资源
            chain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter的init初始化");

        //1.获取Filter的名称filter-name的内容
        System.out.println("Filter-name" + filterConfig.getFilterName());
        //2.获取在web.xml中配置的init-param初始化参数
        System.out.println("初始化参数username值是：" + filterConfig.getInitParameter("username"));
        System.out.println("初始化参数url值是：" + filterConfig.getInitParameter("url"));
        //3.获取ServletContext对象
        System.out.println(filterConfig.getServletContext());
    }
    @Override
    public void destroy() {

    }
}
