package com.zen.navigation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zen.navigation.dao")
public class NavigationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NavigationApplication.class, args);
    }

}
