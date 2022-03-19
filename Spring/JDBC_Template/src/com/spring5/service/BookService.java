package com.spring5.service;

import com.spring5.dao.BookDao;
import com.spring5.entiy.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//在注解里面value属性可以省略
//默认值是类名称，首字母小写   UserService -> userService   ，以下四种注解都可以

//@Component(value = "userService")  //相当于 -> <bean id="user" class="..."/>
//@Repository
//@Controller
@Service
public class BookService {
    /**
     * 定义dao类型属性
     * 注解中已经封装set方法，不需要添加 set 方法
     * 添加注入属性 @Autowired注解
     */
    //注入dao
    @Autowired
    private BookDao bookDao;

    //添加方法
    public void addBook(Book book){
        bookDao.add(book);
    }

    //修改方法
    public void updateBook(Book book){
        bookDao.updateBook(book);
    }

    //删除方法
    public void deleteBook(int id){
        bookDao.deleteBook(id);
    }

    //查询表记录数
    public int findCount(){
        return bookDao.selectCount();
    }

    //查询返回对象
    public Book findOne(int id){
        return bookDao.findBookInfo(id);
    }

    //查询返回集合
    public List<Book> findAll(){
        return bookDao.findAllBook();
    }

    //批量添加
    public void batchAdd(List<Object[]> batchArgs){
        bookDao.batchAddBook(batchArgs);
    }

    //批量修改
    public void batchUpdate(List<Object[]> batchArgs){
        bookDao.batchUpdate(batchArgs);
    }

    //批量删除
    public void batchDelete(List<Object[]> batchArgs){
        bookDao.batchDelete(batchArgs);
    }
}
