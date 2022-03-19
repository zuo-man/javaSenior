package com.spring5.dao;

import com.spring5.entiy.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加的方法
    @Override
    public void add(Book book) {
        //1.创建sql语句
        String sql = "insert into book values(?,?,?)";
        //2.调用方法实现
        int update = jdbcTemplate.update(sql, book.getId(), book.getName(), book.getState());
        System.out.println(update);
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update book set name=?,state=? where id=?";
        int update = jdbcTemplate.update(sql, book.getName(), book.getState(), book.getId());
        System.out.println(update);
    }

    @Override
    public void deleteBook(int id) {
        String sql = "delete from book where id=?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    //查询表记录数
    @Override
    public int selectCount() {
        String sql = "select count(*) from book";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    //查询返回对象
    @Override
    public Book findBookInfo(int id) {
        String sql = "select * from book where id=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    //查询返回集合
    @Override
    public List<Book> findAllBook() {
        String sql = "select * from book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    //批量添加
    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into book value(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        //输出影响行数
        System.out.println(Arrays.toString(ints));
    }

    //批量修改
    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        String sql = "update book set name=?,state=? where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        //输出影响行数
        System.out.println(Arrays.toString(ints));
    }

    //批量删除
    @Override
    public void batchDelete(List<Object[]> batchArgs) {
        String sql = "delete from book where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(ints);
    }

}
