package com.example.servlet;

import com.example.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @create 2021-12-30 10:59
 */
public class CookieServlet extends BaseServlet {

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        //getContextPath() ==> 得到工程路径
        cookie.setPath( req.getContextPath() + "/abc"); // 工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有Path路径的Cookie");
    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie);

        resp.getWriter().write("Cookie保存成功");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();

        //查找全部 Cookie
//        for(Cookie C : cookies){
//            //getname:返回Cookie的key，getvalue：返回Cookie的value
//            resp.getWriter().write("Cookie[" + C.getName() + "=" + C.getValue() + "] <br/>" );
//        }

        Cookie wantCookie = CookieUtils.findCookie("key1",cookies);

        //如果不等于null，说明赋过值，也就找到了指定Cookie
        if(wantCookie != null){
            resp.getWriter().write("找到了需要的Cookie");
        }

        //找特定的Cookie键值
//        for(Cookie C : cookies){
//            if("key1".equals(C.getName())){
//                wantCookie = C;
//                break;
//            }
//        }
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 方案一：
        //1.先创建一个要修改的同名的Cookie对象  2.在构造器赋予新的Cookie的值
//        Cookie cookie = new Cookie("key1","newValue1");
        //3.调用response.addCookie( Cookie ); 通知客户端保存修改
//        resp.addCookie(cookie);

        //方案二：
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if(cookie != null){
            //2.调用setValue()方法赋予新的Cookie值
            cookie.setValue("newValue2");
            //3.调用response.addCookie()通知客户端保存修改
            resp.addCookie(cookie);
        }

        resp.getWriter().write("key1的value值已修改");
    }

    //Cookie生命周期
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defalutLife", "defalutLife");

        /*setMaxAge()
            正数：表示在指定的秒数后过期
            负数：表示浏览器一关，Cookie就回被删除（默认值是 -1）
            0：表示马上删除Cookie
         */
    }

    //马上删除Cookie
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先找到要删除的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if(cookie != null){
            //调用setMaxAge(0)
            cookie.setMaxAge(0); //删除此Cookie
            //调用response.addCooke(cookie);
            resp.addCookie(cookie);

            resp.getWriter().write("key1Cookie已被删除");
        }
    }

    //Cookie存活时间
    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600","life3600");
        //设置Cookie一小时后被删除，无效
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);
        resp.getWriter().write("创建一个存活一小时的Cookie");
    }
}
