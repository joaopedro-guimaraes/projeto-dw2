package org.spring.mvc.controller;

import org.hibernate.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "/controller", method = RequestMethod.POST)
    public ModelAndView Logar(User user, HttpSession session){

        if(user.getPassword().equals("senha123")) {
            String messageSuccess = "Welcome!! Usuário logado com sucesso.";
            session.setAttribute("user", user.getUsername());

            return new ModelAndView("/hello/view", "message", messageSuccess);
        }

        String messageFail = "Login não permitido!";
        return new ModelAndView("/hello/view2", "message", messageFail);
    }
}
