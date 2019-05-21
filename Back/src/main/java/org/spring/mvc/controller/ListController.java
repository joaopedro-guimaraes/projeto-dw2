package org.spring.mvc.controller;

import org.hibernate.entity.User;
import org.hibernate.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/list")
public class ListController {

    @RequestMapping(value = "/controller", method = RequestMethod.POST)
    public ModelAndView List(HttpSession session){

        String message = "";

        UserMapper usm = new UserMapper();
        List<User> users = usm.List();

        for (User u : users) {
            message += u.toString();
        }

        return new ModelAndView("/hello/view2", "message", message);
    }
}
