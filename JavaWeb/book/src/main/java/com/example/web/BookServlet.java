package com.example.web;

import com.example.pojo.*;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import com.example.utils.WebUtils;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @create 2021-12-23 14:31
 */
public class BookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //添加操作后，让pageNo当前页加一
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo += 1;
        //1.获取请求的参数==封装称为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());

        //2.调用BookService.addBook()保存图书
        bookService.addBook(book);
        //3.跳转图书列表页面
        /*
          /manager/bookServlet?action = list
         请求转发的斜杠 / 表示到工程名
         若使用请求转发增加图书信息，当用户提交完请求，浏览器会记录下最后一次请求的全部信息。
         当用户按下功能键F5刷新时，就会发起浏览器记录的最后一次请求，也就重复提交数据，所以要用重定向提交数据
         */
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);

        //使用重定向，重定向的斜杠 / 表示到端口号  ，getContextPath：获取工程名
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);



    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数==封装称为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2.调用BookService.updateBook(Book)；修改图书
        bookService.updateBook(book);
        //3.重定向回图书列表管理页面，获取修改后传递过来的页面
        resp.sendRedirect(req.getContextPath()
                + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }
    // 修改图书时，获取需要修改的图书信息
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.调用bookService.queryBookById查询图书
        Book book = bookService.queryBookById(id);
        //3.保存图书到Request域中
        req.setAttribute("book", book);
        //4.请求转发到  pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数id，图书编程
        int id = WebUtils.parseInt(req.getParameter("id") ,0);
        //2.调用bookService.deleteBookById()；删除图书
        bookService.deleteBookById(id);
        //3.重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    //显示所有图书
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2.把全部图书保存到Requst域中
        req.setAttribute("books", books);
        /*
        3.请求转发到/pages/manager/book_manager.jsp页面
         斜杠/表示到工程名，也就是映射到web目录下
         */
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    //分页
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);//默认显示第一页
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //2.调用BookService.page(pageNo.pageSize)：Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        //设置分页条的请求地址
        page.setUrl("manager/bookServlet?action=page");
        //3.保存Page对象到Request域中
        req.setAttribute("page", page);
        //4.请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
