package com.boot.admin;

import com.boot.bean.TUser;
import com.boot.mapper.TUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@SpringBootTest
class ApplicationTests {

    //boot容器中已经配置好jdbcTemplate
    @Autowired
    JdbcTemplate jdbcTemplate;

    //当容器中没有数据源时，DataSourceConfig创建默认数据源HikariDataSource，此时容器中自己配置了druid
    //数据源HikariDataSource失效，此时数据源是durid
    @Autowired
    DataSource dataSource;


    @Test
    public void jdbcTest(){
//        jdbcTemplate.queryForObject("select * from t_user");
        //将查询的数据封装集合
//        jdbcTemplate.queryForList("select * from t_user");
        Long along = jdbcTemplate.queryForObject("select count(1) from t_user", Long.class);
        log.info("记录总数：{}", along);

        log.info("数据源类型：{}", dataSource.getClass());
    }


    @Autowired
    TUserMapper tUserMapper;
    //mybatis-plus 获取用户信息
    @Test
    void TUserMapperTest(){
        TUser tUser = tUserMapper.selectById(1);
        log.info("用户信息：{}", tUser);
    }


}
