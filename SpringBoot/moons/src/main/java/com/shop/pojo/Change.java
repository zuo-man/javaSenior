package com.shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 此类为 User 转换类， 无实际意义
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Change implements Serializable {

    private Integer id;
    private String username;
    private String password;

    private String[] roleName;

    private String nickName;
    private String salt;
    private String gmtcreate;
    private String gmtmodified;
    private Integer deleted;



    public static Change UserChange(User user) {
        Change change = new Change();

        change.setId(user.getId());
        change.setUsername(user.getUsername());
        change.setPassword(user.getPassword());

        //将 String类型 RoleName 转换为Stirng[]数组类型，并返回
        String roleName = user.getRoleName();
        String[] role = new String[1];
        role[0] = roleName;
        change.setRoleName(role);


        change.setNickName(user.getNickName());
        change.setSalt(user.getSalt());
        change.setGmtcreate(user.getGmtcreate());
        change.setGmtmodified(user.getGmtmodified());
        change.setDeleted(user.getDeleted());


        return change;
    }

}

