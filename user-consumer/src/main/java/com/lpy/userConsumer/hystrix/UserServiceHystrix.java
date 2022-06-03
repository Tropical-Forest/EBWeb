package com.lpy.userConsumer.hystrix;

import com.lpy.common.entity.User;
import com.lpy.userConsumer.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserService {

    @Override
    public int register(String upassword, String uname, String usex) {
        return 0;
    }

    @Override
    public User login(String uname) {
        return null;
    }
}
