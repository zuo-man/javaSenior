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


    @Test
    public void test1(){

        String date = "2022-05-28 07:53:20";
        //String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
        System.out.println(date.substring(10, 15));
        System.out.println(date.substring(9, 15));
        System.out.println(date.substring(11, 16));

    }

}
