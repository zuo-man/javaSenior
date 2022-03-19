package com.example.web;

import com.example.pojo.*;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import com.example.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-01-03 17:22
 */
public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 加入购物车
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数  商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookById(id): Book得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息，转换成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        //重定向回商品列表页面         获取请求头Referer：原来地址的路径
        resp.sendRedirect(req.getHeader("Referer"));

        //最后一个添加的商品名称
        req.getSession().setAttribute("lastName", cartItem.getName());
    }

    /**
     * 添加购物车，并用Ajax局部更新数量和名称
     */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数  商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookById(id): Book得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息，转换成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        //最后一个添加的商品名称
        req.getSession().setAttribute("lastName", cartItem.getName());

         //6.返回购物车总的商品数量和最后一个添加的商品名称
        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName", cartItem.getName());

        Gson gson = new Gson();
        String jsonResult = gson.toJson(resultMap);

        resp.getWriter().write(jsonResult);
    }

    /**
     * 删除购物车商品项
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            //删除了购物车指定id商品项
            cart.deleteItem(id);
            //重定向回原来的购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            //清空购物车
            cart.clear();
            //重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 修改商品数量
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数 商品编号、商品数量
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        //获取cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            //修改商品数量
            cart.updateCount(id, count);
            //重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

}