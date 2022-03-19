package com.example.util;

import javax.servlet.http.Cookie;

/**
 * @create 2022-01-02 17:10
 */
public class CookieUtils {

    /**
     * 查找指定名称的Cookie对象
     */
    public static Cookie findCookie(String name, Cookie[] cookies){
        if( name == null || cookies == null || cookies.length == 0 ){
            return null;
        }

        for(Cookie cookie : cookies){
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }

        return null;
    }
}
