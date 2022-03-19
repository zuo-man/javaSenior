package com.example.web;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 注册，已整合为UserServlet
 * @create 2021-12-13 17:27
 */
public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    //Ctrl+Alt+L可以格式化代码，idea帮你整理空格，换行等
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//编辑传入mysql字符集，否则会乱码
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2.检查 验证码是否正确 === 验证码由服务器生成，这里先写死，要求验证码为123
        if ("123".equalsIgnoreCase(code)) {      //IgnoreCase：忽略大小写
            //3.检查 用户名是否可用
            if (userService.existsUsername(username)) {
                System.out.println("用户名 [" + username + "] 已存在");
                //把回显信息，保存到Request域中
                req.setAttribute("error","用户名已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
//                req.setAttribute("captcha", code);//验证码回显

                //跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);//请求转发必须以斜杠 / 打头
            } else {
                //调用Service保存到数据库
                userService.registUser(new User(null, username, password, email));
                //跳转到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        } else {
            //把回显信息，保存到Request域中
            req.setAttribute("error","验证码输入错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            System.out.println("验证码[" + code + "]错误");
            //跳回注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);//请求转发必须以斜杠 / 打头
        }
    }
}






