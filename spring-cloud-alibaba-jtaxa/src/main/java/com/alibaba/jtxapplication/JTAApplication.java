package com.alibaba.jtxapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.alibaba"})
public class JTAApplication {

    public static void main(String[] args){
        SpringApplication.run(JTAApplication.class,args);
    }
}
