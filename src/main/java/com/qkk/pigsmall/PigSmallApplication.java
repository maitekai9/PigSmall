package com.qkk.pigsmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.qkk.pigsmall.mapper")
@SpringBootApplication
public class PigSmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(PigSmallApplication.class, args);
    }

}
