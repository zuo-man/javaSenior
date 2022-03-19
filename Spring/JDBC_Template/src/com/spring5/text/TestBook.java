package com.spring5.text;

import com.spring5.entiy.Book;
import com.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestBook {
    //增删改
    @Test
    public void testJdbcTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("druid.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        Book book = new Book();
        book.setId(3);
        book.setName("朱诺");
        book.setState("好");
        //添加
        bookService.addBook(book);
        //修改
//        bookService.updateBook(book);
        //删除
//        bookService.deleteBook(3);
    }
    //查
    @Test
    public void testQuery(){
        ApplicationContext context = new ClassPathXmlApplicationContext("druid.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        //查询返回某个值
        int count = bookService.findCount();
        System.out.println(count);

        //查询返回对象
        Book book = bookService.findOne(2);
        System.out.println(book);

        //查询返回所有对象
        List<Book> all = bookService.findAll();
        System.out.println(all);
    }
    //批量操作
    @Test
    public void testBatch(){
        ApplicationContext context = new ClassPathXmlApplicationContext("druid.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        //批量添加
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {3,"小真","sd"};
//        Object[] o2 = {4,"千姬","f"};
//        Object[] o3 = {5,"沐恩","we"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchAdd(batchArgs);

        //批量修改
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"丽达","sd",3};
//        Object[] o2 = {"艾琳","f",4};
//        Object[] o3 = {"伊克斯","wse",5};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchUpdate(batchArgs);

        //批量删除
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {3};
//        Object[] o2 = {4};
//        Object[] o3 = {5};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchDelete(batchArgs);
    }
}
