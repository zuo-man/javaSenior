package com.example.filter;

import com.example.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @create 2022-01-10 18:59
 */
public class TransactionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);

            JdbcUtils.commitAndClose(); //提交事务

        } catch (Exception e) {

            JdbcUtils.rollbackAndClose(); //回滚事务

            e.printStackTrace();

            throw new RuntimeException();/* 继续抛异常给Tomacat服务器，用来管理展示友好的错误页面 */
        }
    }
}
