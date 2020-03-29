package com.alibaba.service;

import com.alibaba.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/*
* 使用 Fegin调用时。服务名称不能出现“_”,但支持“-”
* */

@FeignClient(value = "nacos-user-provider")
public interface UserService {

    @GetMapping(value="/queryuserinfo")
    public UserModel queryUserInfo();
}
