package com.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 只需要Mapper继承于 BaseMapper，就有CRUD
 * @Repository ：将类或接口标识为持久化组件 ，注入UserMapper就没问题了，也可以不加
 */

@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 自定义方法，对应映射文件为mapper下的 UserMapperxml
     * 根据id查询用户信息为map集合
     */
    Map<String, Object> selectMapById(Long id);


    /**
     * 自定义方法，根据年龄查询用户信息 并且进行分页
     * Page ：mybatis-plus提供的分页对象，必须位于第一个参数的位置，才能被分页拦截器拦截
     */
                        //@Param：规定参数访问规则
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);



}
