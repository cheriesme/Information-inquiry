package com.example.springbootmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.example"})
@SpringBootApplication
public class  SpringBootManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootManagerApplication.class, args);
    }

}
