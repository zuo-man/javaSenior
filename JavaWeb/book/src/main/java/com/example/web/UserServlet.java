package com.example.web;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import com.example.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 用户登录注册
 * @create 2021-12-21 16:44
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 处理登录的功能
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //登录的代码
        req.setCharacterEncoding("UTF-8");//编辑传入mysql字符集，否则会乱码
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用 userService.login()登录处理业务
        User loginuser = userService.login(new User(null, username, password, null));
        //如果等于null，说明登录失败
        if (loginuser == null) {
            //把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("error", "用户名或密码错误");
            req.setAttribute("username", username);

            //跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //保存用户登录的信息到Session域中
            req.getSession().setAttribute("user", loginuser);
            //跳转到登录成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 处理注册的功能
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码，防止重复提交
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //注册的代码
        req.setCharacterEncoding("UTF-8");//编辑传入mysql字符集，否则会乱码
        //方式一：1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //方式二：1.获取请求的参数
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        //2.检查 验证码是否正确 === 验证码由服务器生成，这里先写死，要求验证码为123
        if (token!= null && token.equalsIgnoreCase(code)) {      //IgnoreCase：忽略大小写
            //3.检查 用户名是否可用
            if (userService.existsUsername(username)) {
                System.out.println("用户名 [" + username + "] 已存在");
                //把回显信息，保存到Request域中
                req.setAttribute("error", "用户名已存在");
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
            req.setAttribute("error", "验证码输入错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            System.out.println("验证码[" + code + "]错误");
            //跳回注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);//请求转发必须以斜杠 / 打头
        }
    }

    /**
     * 获取ajax传过来的数据，检查用户名是否可用
     */
    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数username
        String username = req.getParameter("username");
        //调用userService.existsUsername();
        boolean existsUsername = userService.existsUsername(username);
        //把返回的结果封装成为map对象
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername", existsUsername);

        //Json格式字符串传回给客户端
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        resp.getWriter().write(json);
    }

    //注销
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.销毁Session中用户登录的信息（或者销毁Session）
        req.getSession().invalidate();
        //2.重定向到首页（或登录界面）
        resp.sendRedirect(req.getContextPath());
    }
}
