package com.example.test;

import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @create 2021-12-23 14:16
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addTest(){
        bookService.addBook(new Book(null, "格兰尼", "123", new BigDecimal(12),22,33,null));
    }

    @Test
    public void updateBook(){
        bookService.updateBook(new Book(10,"无暇","234",new BigDecimal(23),12,32,null));
    }

    @Test
    public void deleteBook(){
        bookService.deleteBookById(6);
    }

    @Test
    public void queryBookById(){
        System.out.println(bookService.queryBookById(10));
    }

    @Test
    public void queryBooks(){
        for(Book E : bookService.queryBooks()){
            System.out.println(E);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE, 10, 50));
    }
}
