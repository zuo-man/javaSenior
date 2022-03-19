package com.spring5.factorybean;

import com.spring5.collection.Teacher;
import org.springframework.beans.factory.FactoryBean;

/**
 * @create 2022-02-26 15:23
 */
public class MyBean implements FactoryBean<Teacher> {

    //定义返回bean
    @Override
    public Teacher getObject() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setName("千姬");
        return teacher;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
