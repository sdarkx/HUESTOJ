//// -*- coding = utf-8 -*-
//// @Time : 2022/11/27 0027 14:40
//// @Author : x_DARK_
//// @File : MybatisPlusConfig.java
//// @Software : IntelliJ IDEA
//
//package com.zut.oj.common;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//
///**
// * mybatis-plus 分页插件
// */
//@Configurable
//@MapperScan("com.zut.oj.mapper")
//public class MybatisPlusConfig {
//
//    /**
//     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
//     */
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//        return interceptor;
//    }
//}
