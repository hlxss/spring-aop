package com.sheng;

import com.sheng.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = ac.getBean("userServiceImpl", UserService.class);
        userService.login("admin", "111");
    }
}
