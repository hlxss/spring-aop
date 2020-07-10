package com.sheng.service;

import com.sheng.entity.User;

public interface UserService {
    User login(String username, String password);
}
