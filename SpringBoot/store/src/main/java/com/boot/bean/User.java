package com.boot.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private Integer id;
    private String username;
    private String password;
    private Integer tatus;
    private String head;
    private String address;
    private String sex;
    private String modifytime;
    private String classes;
}
