package com.sheng.service.impl;

import com.sheng.entity.User;
import com.sheng.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User login(String username, String password) {
        System.out.println("3、aop --> login方法");
//        System.out.println(1 / 0);
        return null;
    }
}
