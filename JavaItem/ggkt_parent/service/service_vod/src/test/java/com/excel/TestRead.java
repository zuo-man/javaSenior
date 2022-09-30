package com.excel;

import com.alibaba.excel.EasyExcel;

//EasyExcel 读文件（ 读操作 ）
public class TestRead {

    public static void main(String[] args) {

        //设置文件名称和路径
        String fileName = "D:\\text.xlsx";
        //调用方法进行读操作，默认读取第一个sheet
        EasyExcel.read(fileName, User.class, new ExcelListener()).sheet().doRead();

    }

}
