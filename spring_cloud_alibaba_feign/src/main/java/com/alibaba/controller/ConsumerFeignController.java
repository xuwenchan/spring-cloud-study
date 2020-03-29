package com.alibaba.controller;

import com.alibaba.model.UserModel;
import com.alibaba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
* RestController 和Controller 的去别
* Controller 返回一个字符串代表要跳转的页面的路径，如果要返回数据，加@ResponseBody
*
* RestController 则
*
* */


@RestController
public class ConsumerFeignController {

    @Autowired
    UserService userService;



    @ResponseBody
    @GetMapping(value="/queryuserinfo")
    public UserModel queryUserInfo(){
        return userService.queryUserInfo();
    }


}
