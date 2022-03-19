package com.spring5.life;

/**
 * @create 2022-02-26 16:09
 */
public class Orders {

    //无参数构造
    public Orders(){
        System.out.println("第一步 执行无参数构造创建bean实例");
    }

    private String name;
    public void setName(String name){
        this.name = name;
        System.out.println("第二部 调用set方法设置属性值");
    }

    //创建执行的初始化方法
    public void initMethod(){
        System.out.println("第三步 执行初始化方法");
    }

    //创建执行的销毁的方法
    public void destroy(){
        System.out.println("第五步 执行销毁方法");
    }

    @Override
    public String toString() {
        return "Orders{" +
                "name='" + name + '\'' +
                '}';
    }
}
