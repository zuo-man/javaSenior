package com.example.service;

import com.example.pojo.Book;
import com.example.pojo.Page;

import java.util.List;

/**
 * @create 2021-12-23 13:52
 */
public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    //传pageNo：当前页码， pageSize：当前页显示数量，全局常量4
    Page<Book> page(int pageNo, int pageSize);

    //重载的查询价格区间的方法
    Page<Book> page(int pageNo, int pageSize, int min, int max);
}
