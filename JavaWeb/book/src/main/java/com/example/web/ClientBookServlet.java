package com.example.web;

import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import com.example.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 将分页数据请求转发到首页index.jsp
 */
public class ClientBookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    //首页的分页
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);//默认显示第一页
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //2.调用BookService.page(pageNo.pageSize)：Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        //设置分页条的请求地址
        page.setUrl("client/bookServlet?action=page");
        //3.保存Page对象到Request域中
        req.setAttribute("page", page);
        //4.请求转发到pages/client/index.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }


    //查询价格区间的分页
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);//默认显示第一页
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);//max_value：integer定义的2147483647值

        //2.调用BookService.page(pageNo.pageSize)：Page对象
        Page<Book> page = bookService.page(pageNo, pageSize, min, max);

        StringBuilder st = new StringBuilder("client/bookServlet?action=pageByPrice");
        //如果有最小价格的参数，追加到分页的地址参数中
        if(req.getParameter("min") != null){
            st.append("&min=").append(req.getParameter("min"));
        }
        //如果有最大价格的参数，追加到分页的地址参数中
        if(req.getParameter("max") != null){
            st.append("&max=").append(req.getParameter("max"));
        }

        //设置分页条的请求地址
        page.setUrl(st.toString());
        //3.保存Page对象到Request域中
        req.setAttribute("page", page);
        //4.请求转发到pages/client/index.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
