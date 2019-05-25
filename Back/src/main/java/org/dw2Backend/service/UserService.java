package org.dw2Backend.service;

import org.dw2Backend.entity.User;
import org.dw2Backend.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public UserService() {}

    public boolean Authenticate(User user){
        return userMapper.Authenticate(user);
    }
}
