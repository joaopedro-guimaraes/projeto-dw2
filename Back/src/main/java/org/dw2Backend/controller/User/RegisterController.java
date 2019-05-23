package org.dw2Backend.controller.User;

import org.dw2Backend.entity.User;
import org.dw2Backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/register")
public class RegisterController{

    private UserMapper userMapper;

    @Autowired
    public RegisterController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public RegisterController() {}

    @Transactional
    @RequestMapping(value = "/controller", method = RequestMethod.POST)
    public ModelAndView Register(User user, HttpSession session){

        userMapper.Insert(user);

        String message = "Cadastro efetuado com sucesso!";
        return new ModelAndView("/hello/view3", "message", message);
    }
}