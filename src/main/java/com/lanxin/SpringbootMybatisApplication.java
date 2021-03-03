package com.lanxin;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lanxin.dao")
@SpringBootApplication
public class SpringbootMybatisApplication {//springboot启动类

    public static void main(String[] args) {
        System.out.println("你们好");
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

}
