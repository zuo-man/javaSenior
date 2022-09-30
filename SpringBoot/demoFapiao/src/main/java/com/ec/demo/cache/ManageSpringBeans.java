package com.ec.demo.cache;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy(false)
public class ManageSpringBeans implements ApplicationContextAware {
    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    private static void checkApplicationContext(){
        if (context==null){
            throw new IllegalStateException("applicationContext is not injected error");
        }
    }

    /**
     * 获取某个类型的bean
     * @param requiredType
     * @param <T>
     * @return
     */
    public static <T> T getBean(final Class<T> requiredType){
        checkApplicationContext();
        return context.getBean(requiredType);
    }

    /**
     * 通过名字获取bean
     * @param requiredType
     * @param name
     * @param <T>
     * @return
     */
    public static <T> T getBean(final Class<T> requiredType,String name){
        checkApplicationContext();
        return context.getBean(name,requiredType);
    }

}
