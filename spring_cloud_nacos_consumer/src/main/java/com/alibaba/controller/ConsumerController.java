package com.alibaba.controller;

import com.alibaba.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/api/consumer/user")
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @GetMapping(value = "/loadblancetest")
    public UserModel echo() {
        //使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos_user_provider");
        String url = String.format("http://%s:%s/%s", serviceInstance.getHost(), serviceInstance.getPort(), "queryuserinfo");
        System.out.println("url:"+url);
        System.out.println("ip:"+serviceInstance.getHost()+",port:"+serviceInstance.getPort());
        return restTemplate.getForObject(url, UserModel.class);
    }
}
