package com.example.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.net.URLEncoder;

/**
 * @create 2021-12-21 12:15
 */
public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取要下载的文件名
        String downfile = "2.jpg";
        //2.读取要下载的文件内容（通过ServletContext对象可以读取）
        ServletContext servletContext = getServletContext();

        //获取要下载的文件类型
        String Type = servletContext.getMimeType("/file/" + downfile);
        System.out.println("下载的文件类型:" + Type);
        //4.在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(Type);
        /**
         * 5.告诉客户端收到的数据是用于下载使用（还是使用响应头）
         * Content-Disposotion响应头，表示收到的数据怎么处理
         * attachment表示附件，表示下载使用
         * filename = 表示指定下载的文件名，可以与下载的文件名不同，文件取名是中文时，需要进行URLEncoder编码转换
         */
        resp.setHeader("Content-Disposition",
        "attachment; filename=" + URLEncoder.encode("自定义文件名.jpg","UTF-8"));

        //resp.setHeader("Content-Dispositin","attachment; filename==?UTF-8?B?" new BASE64Encoder().encode("中文.jpg".getBytes("UTF-8")) + "?=");//若是BASE64编码

        /**
         * /斜杠被服务器解析表示地址为http://ip:prot/工程名/ 映射到代码的web目录
         */
        InputStream in = servletContext.getResourceAsStream("/file/" + downfile);
        //获取相应的输出流
        OutputStream out = resp.getOutputStream();
        /**
         *  3.把下载的文件内容回传给客户端
         *  读取输入流 in 中的全部数据，复制给输出流 out ，输出给客户端
         *  commons-io jar包提供的输入输出流，用来获取文件流
         */
        IOUtils.copy(in, out);

    }
}
