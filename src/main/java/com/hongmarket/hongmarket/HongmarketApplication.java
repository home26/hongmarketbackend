package com.hongmarket.hongmarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.hongmarket.hongmarket.dao")
public class HongmarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(HongmarketApplication.class, args);
    }

}
