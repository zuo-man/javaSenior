package com.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data   //lombok的注解，只会在程序编译时，使bean自动生成GetSet方法 ，让源代码看的更清晰
@ToString  //lombok的注解，生成ToString
@NoArgsConstructor  //lombok的注解，生成无参构造器
@AllArgsConstructor //lombok的注解，生成有参构造器

public class Pet {

    private String name;
    private Double weight;

}
