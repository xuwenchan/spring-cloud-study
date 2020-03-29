package com.alibaba.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.alibaba.service"})
@ComponentScan(basePackages = {"com.alibaba"})
public class SentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class,args);
    }
}
