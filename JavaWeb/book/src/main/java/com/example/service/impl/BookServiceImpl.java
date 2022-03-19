package com.example.service.impl;

import com.example.dao.BookDao;
import com.example.dao.impl.BookDaoImpl;
import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.BookService;

import java.util.List;

/**
 * @create 2021-12-23 14:03
 */
public class BookServiceImpl implements BookService {

    //创建BookDaoImpl，使得service层和Dao层分耦
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    /** 实现首页分页
     */
    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();

        //设置每页显示的数量
        page.setPageSize(pageSize);

        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);

        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }

        //设置总页码
        page.setPageTotal(pageTotal);

        //设置当前页码
        page.setPageNo(pageNo);

        //求当前页面数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        //设置当前页数据
        page.setItems(items);

        return page;
    }

    /** 重载实现查询价格区间的分页
     */
    @Override
    public Page<Book> page(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();

        //设置每页显示的数量
        page.setPageSize(pageSize);

        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);

        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }

        //设置总页码
        page.setPageTotal(pageTotal);

        //设置当前页码
        page.setPageNo(pageNo);

        //求当前页面数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize, min, max);
        //设置当前页数据
        page.setItems(items);

        return page;
    }
}
