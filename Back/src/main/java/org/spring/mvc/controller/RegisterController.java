package org.spring.mvc.controller;

import org.hibernate.entity.User;
import org.hibernate.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @RequestMapping(value = "/controller", method = RequestMethod.POST)
    public ModelAndView Register(User user, HttpSession session){

        UserMapper usm = new UserMapper();
        usm.Insert(user);

        String message = "Cadastro efetuado com sucesso!";
        return new ModelAndView("/hello/view3", "message", message);
    }
}