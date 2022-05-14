package com.shop.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {

    //添加分页插件    mybatis也有分页插件，MybatisPlusInterceptor拦截器，是因为对查询功能进行拦截，基础上再增强功能，以完成分页
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor pageInterceptor = new MybatisPlusInterceptor();

        //这是分页拦截器
        PaginationInnerInterceptor pagination = new PaginationInnerInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        pagination.setOverflow(true);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        pagination.setMaxLimit(500L);
        // 开启 count 的 join 优化,只针对部分 left join
//        paginationInnerInterceptor.setDbType(DbType.MYSQL);   //设置数据库类型

        pageInterceptor.addInnerInterceptor(pagination);
        //添加乐观锁插件
        pageInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());

        return pageInterceptor;
    }
}
