package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com"})
//@ComponentScan(basePackages={"com.springboot.controller","com.springboot.domain","com.springboot.repository","com.springboot.repository.impl","com.springboot.service","com.springboot.service.impl"})
public class Application extends SpringBootServletInitializer {



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
