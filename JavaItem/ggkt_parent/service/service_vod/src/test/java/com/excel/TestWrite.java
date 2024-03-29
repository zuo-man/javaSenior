package com.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

//EasyExcel 生成文件（ 写操作 ）
public class TestWrite {

    public static void main(String[] args) {

        //设置文件名和路径
        String fileName = "D:\\text.xlsx";
        //调用方法
        EasyExcel.write(fileName, User.class)
                .sheet("写操作")
                .doWrite(data());

    }

    //循环设置要添加的数据，最终封装到 List集合中
    private static List<User> data(){
        List<User> list = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            User data = new User();
            data.setId(i);
            data.setName("小优" + i);
            list.add(data);
        }

        return list;
    }

}
