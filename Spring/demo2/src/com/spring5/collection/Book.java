package com.spring5.collection;

import java.util.List;

/**
 * @create 2022-02-26 14:48
 */
public class Book {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void show(){
        System.out.println(list);
    }
}
