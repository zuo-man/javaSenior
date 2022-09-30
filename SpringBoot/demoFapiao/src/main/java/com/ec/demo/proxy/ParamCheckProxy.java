package com.ec.demo.proxy;

import com.ec.demo.annotation.ParamCheck;
import com.ec.demo.exception.MicroException;
import com.ec.demo.utils.ParamCheckUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
@Aspect
public class ParamCheckProxy {

    private static String[] tp = {"com.bocomfintech.syscode.model.bo.CommodityInfoBo","com.bocomfintech.syscode.model.bo.OrderConfInfoBo","com.bocomfintech.syscode.model.bo.OrderInfoBo"};
    private static HashSet<String> tpSet = new HashSet<>(Arrays.asList(tp));

    @Pointcut(value = "@annotation(com.ec.demo.annotation.StartCheck)")
    public void paramCheck(){}

    @Before("paramCheck()")
    public void doBefore(JoinPoint joinPoint) throws MicroException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //获取方法的入参
        Object[] args = joinPoint.getArgs();
        for (Object arg : args){
            paramCheck(arg);
        }
    }

    private static void paramCheck(Object arg) throws MicroException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //如Date类型这般，会在递归时空指针
        if (arg==null){
            return;
        }
        //对于list类型变量，须一层层递归。
        if ("java.util.ArrayList".equals(arg.getClass().getName())){
            Method sizeM = arg.getClass().getDeclaredMethod("size");
            int size = (Integer) sizeM.invoke(arg);
            for (int i = 0; i < size; i++) {
                Method getM = arg.getClass().getDeclaredMethod("get",int.class);
                Object obj = getM.invoke(arg,i);
                paramCheck(obj);
            }
        }

        Class<?> aClass = arg.getClass();
        //获取入参所在类的所有成员变量
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields){
            //解除private限制
            if (!field.isAccessible()){
                field.setAccessible(true);
            }
            //通过get方法得到该成员变量的实例
            Object obj = getFieldValueByName(field.getName(), arg);
            //成员变量为嵌套对象时，递归
            if (tpSet.contains(field.getType().getName())){
                paramCheck(obj);
            }
            //若成员变量为集合类,则遍历每一个对象，递归校验
            if (field.getType().equals(List.class) || field.getType().equals(ArrayList.class)){
                Type genericType = field.getGenericType();
                if (genericType instanceof ParameterizedType){
//                    ParameterizedType pt = (ParameterizedType) genericType;
//                    Class argumentClass = (Class) pt.getActualTypeArguments()[0];

//                    //List中的对象不是项目中的javabean则不扫描
//                    if (!tpSet.contains(argumentClass.getName())){
//                        continue;
//                    }
                    //field.get(arg)即为该list对象本身
                    Object instance = field.get(arg);
                    if (instance==null){
                        continue;
                    }
                    //获得该list类型
                    Class<?> fClass = instance.getClass();
                    //获得list的size()方法
                    Method m = fClass.getDeclaredMethod("size");
                    int size = (Integer) m.invoke(instance);
                    for (int i = 0; i < size; i++) {
                        //获得list的get(i)方法
                        Method getM = fClass.getDeclaredMethod("get",int.class);
                        Object object = getM.invoke(instance,i);
                        //递归
                        paramCheck(object);
                    }

//                    ParameterizedType pt = (ParameterizedType) genericType;
//                    Class argumentClass = (Class) pt.getActualTypeArguments()[0];
//                    //List中的对象不是项目中的javabean则不扫描
//                    if (!tpSet.contains(argumentClass.getName())){
//                        continue;
//                    }
                }
            }
            ParamCheck paramCheck = field.getAnnotation(ParamCheck.class);
            if (paramCheck != null){
                switch(paramCheck.type()){
                    case CHECK_NULL_VALUE:
                        if (ParamCheckUtil.nullValueCheck((String) obj)){
                            throw new MicroException("空值异常");
                        }
                        break;

                    case CHECK_PHONE_NUMBER:
                        if (obj != null && !ParamCheckUtil.phoneNoCheck((String) obj)){
                            throw new MicroException("电话号码不合法");
                        }
                        break;
                    case CHECK_POSTAL_CODE:
                        if (obj != null && !ParamCheckUtil.postalCodeCheck((String) obj)){
                            throw new MicroException("邮政编号不合法");
                        }
                        break;
                }
            }
        }
    }

    //通过String类型名 获取到成员变量的值
    private static Object getFieldValueByName(String fieldName,Object o){
        try{
            String firstLetter = fieldName.substring(0,1).toUpperCase();
            String getter = "get"+firstLetter+fieldName.substring(1);
            Method method = o.getClass().getMethod(getter,new Class[]{});
            Object value = method.invoke(o,new Object[]{});
            return value;
        }catch(Exception e){
            return null;
        }
    }

}
