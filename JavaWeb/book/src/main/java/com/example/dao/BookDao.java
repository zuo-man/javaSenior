package com.example.dao;

import com.example.pojo.Book;

import java.util.List;

/**
 * @create 2021-12-23 11:33
 */
public interface BookDao {
    //对图书的查看、增添删

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();
    //求总记录数
    Integer queryForPageTotalCount();
    //分页数据
    List<Book> queryForPageItems(int begin, int pageSize);

    //价格区间
    Integer queryForPageTotalCountByPrice(int min, int max);
    //价格数据
    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
