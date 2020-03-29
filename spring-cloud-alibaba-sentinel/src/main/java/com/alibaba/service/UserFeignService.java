package com.alibaba.service;

import com.alibaba.callback.UserFeignServiceCallBack;
import com.alibaba.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="nacos-user-provider",fallback= UserFeignServiceCallBack.class)
public interface UserFeignService {
    @GetMapping(value="/queryuserinfo")
    public UserModel queryUserInfo();
}
