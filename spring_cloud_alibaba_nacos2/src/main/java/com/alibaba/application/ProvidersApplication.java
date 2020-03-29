package com.alibaba.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.alibaba"})
public class ProvidersApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProvidersApplication.class,args);
    }
}
