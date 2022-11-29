package com.oj.zut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.oj.zut.mapper")
public class OjBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OjBackendApplication.class, args);
    }

}
