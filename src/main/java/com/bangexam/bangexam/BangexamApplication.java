package com.bangexam.bangexam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author kaneki
 * @date 2019/7/13
 */
@SpringBootApplication
@MapperScan(basePackages = "com.bangexam.bangexam.mapper")
public class BangexamApplication {

    public static void main(String[] args) {
        SpringApplication.run(BangexamApplication.class, args);
    }

}
