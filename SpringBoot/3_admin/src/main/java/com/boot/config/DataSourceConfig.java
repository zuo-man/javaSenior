package com.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

//Deprecated：过时

@Deprecated

//boot starter 已经配置好了druid，下方可以省略
//@Configuration
public class DataSourceConfig {

    //默认数据源的自动配置是判断容器中没有才会配 @ConditionalOnMissingBean(DataSource.class)

    //@ConfigurationProperties：将系统配置和下方的 druid数据源配置绑定， 就可以不用重复写数据库url，uername。。。。
//    @ConfigurationProperties("spring.datasource")
//    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();

//        dataSource.setUrl();
//        dataSource.setUsername();
//        dataSource.setPassword();

        //开启druid数据监控：stat    防火墙：wall
        //和boot绑定，可以在yml中设置
        //    #开启druid数据监控：stat    防火墙：wall
        //    #filters: stat, wall
        //    #max-active: 12      #最大活跃数

//        dataSource.setFilters("stat, wall");

        return dataSource;
    }

    //配置druid的监控页功能
    //localhost:8080/durid
//    @Bean
    public ServletRegistrationBean startViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();

        ServletRegistrationBean<StatViewServlet> re = new ServletRegistrationBean<>(statViewServlet, "/druid/*");

        //配置监控页 登录账号密码
        re.addInitParameter("loginUsername", "123");
        re.addInitParameter("loginPassword", "123");

        return re;
    }

    //WebStatFilter 用于采集web-jdbc关联监控数据
//    @Bean
    public FilterRegistrationBean WebStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();

        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>(webStatFilter);
        //设置监控路径
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        //排除监控路径
        filterRegistrationBean.addInitParameter("exclusions", "*.js, *.gif, *.jpg, *.png, *.css, *.ico, /druid/*");

        return filterRegistrationBean;
    }
}
