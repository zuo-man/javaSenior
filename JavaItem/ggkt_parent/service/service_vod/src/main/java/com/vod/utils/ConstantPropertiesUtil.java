package com.vod.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//InitializingBean：初始化 Bean时，读取配置文件的值，进行赋值
@Component
public class ConstantPropertiesUtil implements InitializingBean {

//    @Value("${file.reigon")
//    private String reigon;

//    public static String END;

    @Override
    public void afterPropertiesSet() throws Exception {
        //将私有reigon公共静态化
//        END = region;
    }
}
