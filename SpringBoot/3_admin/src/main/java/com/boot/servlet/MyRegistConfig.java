package com.boot.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;

//不使用注解 指定源生Servlet组件都放在哪里，@WebServlet、@WebFilter、@WebListener注解得关了

//proxyBeanMethods = true：保证依赖的组件始终的单实例的，默认是true
@Configuration(proxyBeanMethods = true)
public class MyRegistConfig {

//    @Bean
//    public ServletRegistrationBean myServelt(){
//        MyServlet myServlet = new MyServlet();
//
//        return new ServletRegistrationBean(myServlet, "/my");
//    }
//
//    @Bean
//    public FilterRegistrationBean myFilter(){
//        MyFilter myFilter = new MyFilter();
//        //return new FilterRegistrationBean(myFilter, myServlet());
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
//        return filterRegistrationBean;
//    }
//
//    @Bean
//    public ServletListenerRegistrationBean myLisener(){
//        MyServletContextListener myServletContextListener = new MyServletContextListener();
//        return new ServletListenerRegistrationBean(myServletContextListener);
//    }
}
