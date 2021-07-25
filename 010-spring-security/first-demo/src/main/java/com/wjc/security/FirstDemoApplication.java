package com.wjc.security;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <pre>
 *
 * </pre>
 * Author: 王俊超
 * Date: 2021-07-25 17:54
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
@MapperScan(basePackages = "com.wjc.security.mapper")
@SpringBootApplication
public class FirstDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstDemoApplication.class, args);
    }
}
