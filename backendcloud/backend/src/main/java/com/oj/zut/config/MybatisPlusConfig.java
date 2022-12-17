// -*- coding = utf-8 -*-
// @Time : 2022/12/12 0012 19:35
// @Author : x_DARK_
// @File : MybatisPlusConfig.java
// @Software : IntelliJ IDEA

package com.oj.zut.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.oj.zut.mapper")
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加分页插件
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        // 设置请求的页面大于最大页后操作，true调回到首页，false继续请求。默认false
        paginationInnerInterceptor.setOverflow(false);
        // 单页分页条数限制，默认无限制
        paginationInnerInterceptor.setMaxLimit(500L);
        // 设置数据库类型
        paginationInnerInterceptor.setDbType(DbType.MYSQL);
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }

}
