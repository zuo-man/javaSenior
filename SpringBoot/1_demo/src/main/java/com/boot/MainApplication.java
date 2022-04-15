package com.boot;

import ch.qos.logback.classic.db.names.DBNameResolver;
import com.boot.bean.Pet;
import com.boot.bean.User;
import com.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类、主配置类
 * @SrpingBootApplication ：这是一个springBoot应用
 */
@SpringBootApplication      //相当于下方三个注解
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.boot")
public class MainApplication {
    public static void main(String[] args) {

        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2.查看容器中的组件
        String[] names = run.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }

//        //3.从容器中获取组件
//        Pet p1 = run.getBean("big", Pet.class);
//        Pet p2 = run.getBean("big", Pet.class);
//        System.out.println("组件" + (p1 == p2));
//
//        //配置类本身也是组件，也就是代理对象
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
//        //@Configuration(proxyBeanMethods = true) 代理对象方法，boot会检查这个组件是否在容器中存在
//        //保持组件单实例
//        User u1 = bean.user01();
//        User u2 = bean.user01();
//        System.out.println( u1 == u2);
//
//        User user01 = run.getBean("user01", User.class);
//        Pet big = run.getBean("big", Pet.class);
//        System.out.println("用户的宠物：" + (user01.getPet() == big) );
//
//
//        //5.获取所有组件
//        String[] beanNames = run.getBeanNamesForType(User.class);
//        System.out.println("*******");
//        for(String s : beanNames){
//            System.out.println(s);
//        }
//
//        Data bean_DB = run.getBean(Data.class);
//        System.out.println(bean_DB);

        boolean big = run.containsBean("big");
        boolean user01 = run.containsBean("user01");
        System.out.println("容器中是否有big组件：" + big + "，容器中是否有user01：" + user01);


        boolean wuxia_xml = run.containsBean("wuxia_xml");
        boolean cat_xml = run.containsBean("cat_xml");
        System.out.println("容器中是否有xml配置组件：" + wuxia_xml + "，" + cat_xml);
    }
}
