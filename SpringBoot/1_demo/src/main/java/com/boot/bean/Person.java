package com.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component  //将组件加到容器中
@ConfigurationProperties(prefix = "person")     //和配置文件绑定

@Data   //GetSet
@ToString  //lombok的注解，生成ToString
public class Person {

    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private java.util.List<String> animal;
    private Map<String,Object>score;
    private Set<Double> salarys;
    private Map<String, List<Pet>> allPets;



}
