package com.shop.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.shop.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author shengda
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-04-19 10:44:41
* @Entity com.boot.pojo.User
 *
 * @Repository ：将类转换为持久化组件
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

    //自定义Mapper

    //根据用户名 密码查询数据 ，返回User 对象
    User selectByUsernameAndByPassword(@Param("username") String username, @Param("password") String password);

    //根据用户名 查询用户信息
    User selectByUsername(@Param("username") String username);

    /**
     * 自定义方法，模糊查询用户 角色名称
     * Page ：mybatis-plus提供的分页对象，必须位于第一个参数的位置，才能被分页拦截器拦截
     */
                                //@Param：规定参数访问规则
    Page<User> selectByUsernameOrByRoleName(@Param("page") Page<User> page, @Param("username") String username, @Param("roleName") String roleName);


}




