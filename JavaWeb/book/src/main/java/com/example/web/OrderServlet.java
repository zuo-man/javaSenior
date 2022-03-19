package com.example.web;

import com.example.pojo.*;
import com.example.service.OrderService;
import com.example.service.impl.OrderServiceImpl;
import com.example.utils.JdbcUtils;
import com.example.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @create 2022-01-05 13:32
 */
public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();

    /** 生成订单
    */
    protected void createOrder (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取Userid
        User loginUser = (User) req.getSession().getAttribute("user");

        //让用户先登录
        if(loginUser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }

        Integer userId = loginUser.getId();
        //调用orderService.createOrder(Cart, Userid)； 生成订单
        String orderId = orderService.createOrder(cart, userId);

        //防止表单重复提交，使用重定向
//        req.setAttribute("orderId", orderId);
//        //请求转发到/pages/cart/chechout.jsp
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);

        req.getSession().setAttribute("orderId", orderId);

        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");

    }

    /** 根据用户ID查询订单
     */
    public void queryMyIDOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先在页面中获取userId
        User loginUser = (User) req.getSession().getAttribute("user");

        Integer userId = loginUser.getId();
        List<Order> orders = orderService.queryMyIDOrder(userId);

        //把订单保存到Request域中
        req.setAttribute("orders", orders);
        //请求转发
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
    }


    /** 根据订单号查询全部订单信息
     */
    public void queryMyItemOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");

        List<OrderItem> orderItems = orderService.queryMyItemOrder(orderId);

        //把全部订单项保存到Request域中
        req.setAttribute("orderItems", orderItems);
        //请求转发
        req.getRequestDispatcher("/pages/order/orderItems.jsp").forward(req, resp);
    }

}
