package org.dw2Backend.service;

import org.dw2Backend.entity.User;
import org.dw2Backend.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public UserService() {}

    public User Authenticate(User user){
        return userMapper.Authenticate(user);
    }

    public List<User> SearchAll() {
        return userMapper.SearchAll();
    }

    public List<User> SearchById(int id) {
        return userMapper.SearchById(id);
    }

    public User Save(User user) {
        return userMapper.Save(user);
    }

    public boolean Update(User user) {
        return userMapper.Update(user);
    }

    public boolean Delete(User user) {
        return userMapper.Delete(user);
    }
}
