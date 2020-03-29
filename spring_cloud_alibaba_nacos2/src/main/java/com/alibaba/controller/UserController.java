package com.alibaba.controller;

import com.alibaba.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @ResponseBody
    @RequestMapping(value="/queryuserinfo",method = RequestMethod.GET)
    public UserModel queryUserInfo(){
        UserModel user=new UserModel();
        user.setName("xuwenchan");
        user.setAge(18);
        user.setAddress("henan");
        return user;
    }
}
