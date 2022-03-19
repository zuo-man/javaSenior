package com.spring5.text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Spring 5.0 框架自带了通用的日志封装
 * （1）Spring5 已经移除 Log4jConfigListener，官方建议使用 Log4j2
 * （2）Spring5 框架整合 Log4j2
 *
 * 第一步 引入 jar 包
 * 第二步 创建 log4j2.xml 配置文件
 */
public class UserLog {

    private static final Logger log = LoggerFactory.getLogger(UserLog.class);

    public static void main(String[] args){
        log.info("hello ooooooooooooooooooooooooooo");
        log.warn("hello lllllllllllllllllllllllllll");
    }
}
