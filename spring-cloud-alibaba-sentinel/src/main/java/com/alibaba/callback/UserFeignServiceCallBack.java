package com.alibaba.callback;

import com.alibaba.model.UserModel;
import com.alibaba.service.UserFeignService;
import org.springframework.stereotype.Component;

@Component
public class UserFeignServiceCallBack implements UserFeignService {
    @Override
    public UserModel queryUserInfo() {
        UserModel user=new UserModel();
        user.setName("测试名称，触发callback");
        user.setAge(18);
        user.setAddress("henan");
        return user;
    }
}
