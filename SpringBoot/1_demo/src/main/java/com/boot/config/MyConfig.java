package com.boot.config;

import ch.qos.logback.classic.db.names.DBNameResolver;
import com.boot.bean.Car;
import com.boot.bean.Pet;
import com.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.xml.crypto.Data;

/**
 *  1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 *  2、配置类本身也是组件
 *  3、proxyBeanMethods：代理bean的方法
 *         Full(proxyBeanMethods = true)    ：单例，调用方法，会在容器中找单例组件对象
 *         Lite(proxyBeanMethods = false)   ：轻量级，每次调用方法，将产生新的组件对象
 *         组件依赖
 *
 *   4、@Import
 *      给容器中自动创建出声明的组件，默认组件名就是全类名
 *
 *   5、@ImportResource("classpath:beans.xml")导入Spring的配置文件，使之生效
 */

@Import({User.class})
@Configuration(proxyBeanMethods = false)     //告诉boot这是一个配置类 == 配置文件，一般调成false，运行更快
@ImportResource("classpath:beans.xml")  //导入一个资源，容器中获取组件

@EnableConfigurationProperties(Car.class)
//1.开启Car配置绑定功能
//2.把这个Car组件自动注册到容器中

//@ConditionalOnBean(name = "big") //标记在类上，容器中有big 组件时，类的全部组件方法才会生效，否则都不生效
@ConditionalOnMissingBean(name = "big") //标记在类上，容器中 没有 big 组件时，类的全部组件方法执行， 有big组件，就不执行
public class MyConfig {

    /**
     *  外部无论对配置类中的这个组件注册方法调用了多少次获取都是之前注册容器中的单实例对象
     */
    @Bean //给容器中添加组件，以方法名作为组件id，返回类型就是组件类型，返回的值，就是组件在容器中的实例
//    @ConditionalOnBean(name = "big")  //标记在方法上，容器中有 big组件时，才会给容器中注入User01
    public User user01(){
        User you =  new User("小优", 17);
        //user组件依赖了Pet组件
        you.setPet(pet01());
        return you;
    }

//    @Bean("big")
    public Pet pet01(){
        return new Pet("猪🐖" ,12.0);
    }

    //boot底层会配好所有的组件，但是如果用户自己配置了以用户的优先
//    @Bean
//    public CharacterEncodingFilter filter(){
//        return null;
//    }
}
