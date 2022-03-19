package com.example.test;

import com.example.dao.BookDao;
import com.example.dao.impl.BookDaoImpl;
import com.example.pojo.Book;
import com.example.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @create 2021-12-23 13:23
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        //当图书封面给null值时，调用book中if方法，赋值为默认值dew.jpg
        bookDao.addBook(new Book(null,"小优","2343",new BigDecimal(234),33,12,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(9);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(9,"无暇","22",new BigDecimal(22),22,22,null));
    }

    @Test
    public void queryBookById() {
        System.out.println( bookDao.queryBookById(9));
    }

    @Test
    public void queryBooks() {
        for(Book B : bookDao.queryBooks()){
            System.out.println(B);
        }
    }

    //求图书总数量
    @Test
    public void queryForPageTotalCount(){
        System.out.println( bookDao.queryForPageTotalCount());
    }

    //求当前页数据
    @Test
    public void queryForPageItems(){
        for (Book book : bookDao.queryForPageItems(1, Page.PAGE_SIZE)) {
            System.out.println(book);
        }
    }

    //价格区间内的图书数量
    @Test
    public void queryForPageTotalCountByPrice(){
        System.out.println( bookDao.queryForPageTotalCountByPrice(10, 50));
    }

    //价格区间内的图书
    @Test
    public void queryForPageItemsByPrice(){
        for (Book book : bookDao.queryForPageItemsByPrice(1, Page.PAGE_SIZE, 10, 50)) {
            System.out.println(book);
        }
    }

}
