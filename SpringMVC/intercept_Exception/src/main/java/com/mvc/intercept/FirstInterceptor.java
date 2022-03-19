package com.mvc.intercept;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//标注一个类为Spring容器的Bean，（把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
//将SpringMVC配置的拦截器 注入到Component中
@Component
public class FirstInterceptor implements HandlerInterceptor {

    /**
     * 控制器方法执行之前执行preHandle()，其boolean类型的返回值表示是否拦截或放行，返
     * 回true为放行，即调用控制器方法；返回false表示拦截，即不调用控制器方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor --> preHandle");
        //拦截器：是否进行拦截
        //false：拦截  true：放行
        return true;
    }

    /**
     *  控制器方法执行之后执行postHandle()
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor --> postHandle");
    }

    /**
     *  处理完视图和模型数据，渲染视图完毕之后执行afterComplation()
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor --> afterCompletion");
    }
}
