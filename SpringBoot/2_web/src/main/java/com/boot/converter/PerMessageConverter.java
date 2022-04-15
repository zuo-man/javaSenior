package com.boot.converter;

import com.boot.bean.Person;
import com.boot.bean.Pet;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * 自定义Converter
 */
public class PerMessageConverter implements HttpMessageConverter<Person> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        //只要返回值是Person类型就行
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * MessageConverter：消息转换器
     * 服务器要统计所有MessageConverter都能写出哪些内容的类型
     *
     * 此converter转换器能在底层中添加 自定义类型  application/x-guigu
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-guigu");
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //自定义协议数据的写出，   x-guigu的输出格式
        String data = "Converter转换器转成 自定义x-guigu类型数据为： "
                + person.getUserName() + ";" + person.getAge() + ";" + person.getBirth();

        //写出去，写到响应中
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());

    }
}
