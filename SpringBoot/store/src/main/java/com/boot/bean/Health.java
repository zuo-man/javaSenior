package com.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Health {

    private Integer id;
    private Integer uId;    //用户id
    private float temperature;//体温
    private String hot;     //是否发热
    private String leaveout; //是否离开学校
    private String hesuan;  //是否经过核酸
    private Integer masknum;    //口罩剩余数量
    private Date createtime;  //存入时间



}
