package com.baizhi.springboot_jsp_shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.baizhi.springboot_jsp_shiro.mapper")
@SpringBootApplication
public class SpringbootJspShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJspShiroApplication.class, args);
    }

}
