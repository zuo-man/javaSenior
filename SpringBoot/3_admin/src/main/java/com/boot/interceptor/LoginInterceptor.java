package com.boot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * 使用拦截器  进行登录检查
 *
 * 1.配置好拦截器要拦截哪些请求
 * 2.把这些配置放在容器中
 */
public class LoginInterceptor implements HandlerInterceptor {

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录检查逻辑
        //获取session中的User对象
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");

        //简单点，只要有用户，就登录成功
        if(loginUser != null){
            //放行
            return true;
        }else {
            //拦截，然后跳转到登录页面

            //重定向到登录页，在把错误信息传过去
            request.setAttribute("userError", "拦截器告知：请先登录");
//            response.sendRedirect("/");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        }
    }

    //目标方法执行完成之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //页面渲染之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
