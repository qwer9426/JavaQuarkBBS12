package com.quark.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by lhr on 17-7-30.
 */

@SpringBootApplication
@EnableCaching//缓存支持
@MapperScan(value="com.quark.common.dao")
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }
}
