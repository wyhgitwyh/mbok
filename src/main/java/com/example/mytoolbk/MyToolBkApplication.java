package com.example.mytoolbk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mytoolbk.mapper")
public class MyToolBkApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyToolBkApplication.class, args);
    }

}
