package com.spring5.axiom;

import java.lang.reflect.*;
import java.util.Arrays;

public class JDKProxy {

    public static void main(String[] args){
        //创建接口实现类代理对象
                              //类加载器           实现的接口       有两种方式：第一种 匿名实现类，第二种 单独实现类，在new对象
        Class[] imp = {UserDao.class};
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), imp, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
        UserDaoImpl user = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), imp, new UserDaoProxy(user));

        //调用的add 方法，所以add方法被增强
        int result = dao.add(1,2);
        System.out.println("结果为：" + result);
    }
}

//创建代理对象
class UserDaoProxy implements InvocationHandler{

    //1 把创建的是谁的代理对象，把谁传递过来
    //有参数构造传递
    private Object obj;
    public UserDaoProxy(Object obj){
        this.obj = obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //方法之前
        System.out.println("方法之前执行..." + "执行的方法为：" + method.getName()+ "传递的参数..." + Arrays.toString(args));

        //被增强的方法执行
        Object res = method.invoke(obj, args);

        return res;
    }
}
