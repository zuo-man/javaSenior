package com.shop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
public class dataSourceTest {

    //boot容器中已经配置好jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //当容器中没有数据源时，DataSourceConfig创建默认数据源HikariDataSource，此时容器中自己配置了druid
    //数据源HikariDataSource失效，此时数据源是durid
    @Autowired
    private DataSource dataSource;


    @Test
    public void jdbcTest(){
        Long along = jdbcTemplate.queryForObject("select count(1) from user", Long.class);
        log.info("记录总数：{}", along);

        log.info("数据源类型：{}", dataSource.getClass());
    }

}
