package com.spring5.dao;

import com.spring5.entiy.Book;

import java.util.List;

public interface BookDao {

    void add(Book book);

    void updateBook(Book book);

    void deleteBook(int id);

    int selectCount();

    Book findBookInfo(int id);

    List<Book> findAllBook();

    void batchAddBook(List<Object[]> batchArgs);

    void batchUpdate(List<Object[]> batchArgs);

    void batchDelete(List<Object[]> batchArgs);
}
