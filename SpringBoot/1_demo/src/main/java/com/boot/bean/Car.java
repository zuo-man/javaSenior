package com.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件，才会有boot提供的强大功能
 *
 *  方法一：@Component：将组件加到容器中
 *  方法二：@EnableConfigurationProperties：开启Car配置绑定功能
 */

//@Component //将组件加到容器中
@ConfigurationProperties(prefix = "mycar")  //在properties文件中配置

@Data   //lombok的注解，只会在程序编译时，使bean自动生成GetSet方法 ，让源代码看的更清晰
@ToString  //lombok的注解，生成ToString
@NoArgsConstructor  //lombok的注解，生成无参构造器
@AllArgsConstructor //lombok的注解，生成有参构造器
@EqualsAndHashCode  //lombok的注解，生成equals，hashcode
public class Car {

    private String brand;
    private Integer price;

}
