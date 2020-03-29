package com.alibaba.controller;

import com.alibaba.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    @ResponseBody
    @RequestMapping(value="/queryuserinfo",method = RequestMethod.GET)
    public UserModel queryUserInfo(){
        UserModel user=new UserModel();
        user.setName("xuwenchan");
        user.setAge(18);
        user.setAddress("henan");
        return user;
    }

    @GetMapping("/hi")
    public String name(){
        /*从nacos配置中获取最新的值*/
        return configurableApplicationContext.getEnvironment().getProperty("user.name");
    }
}
