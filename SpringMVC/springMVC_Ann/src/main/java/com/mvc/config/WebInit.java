package com.mvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.swing.*;

//web工程的初始化类，用来代替 Web.xml
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     *  指定Spring的配置类
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     *  指定springMVC配置类
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     *  指定DispatcherServlet的映射规则，即url-pattern
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     *  添加过滤器
     */
    @Override
    protected Filter[] getServletFilters() {
        //配置编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");   //设置请求编码
        characterEncodingFilter.setForceResponseEncoding(true);   //设置响应编码
        //配置请求过滤器
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{characterEncodingFilter, hiddenHttpMethodFilter};
    }
}
