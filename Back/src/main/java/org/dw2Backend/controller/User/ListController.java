package org.dw2Backend.controller.User;

import org.dw2Backend.entity.User;
import org.dw2Backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
public class ListController {

    private UserMapper userMapper;

    @Autowired
    public ListController(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public ListController(){}

    @GetMapping
    @RequestMapping(value = "/controller")
    public List<User> List(){
        List<User> users = userMapper.FindAll();
        return users;
    }
}