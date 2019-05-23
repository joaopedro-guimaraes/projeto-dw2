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
import java.util.List;

@Controller
@RequestMapping(value = "/list")
public class ListController {

    private UserMapper userMapper;

    @Autowired
    public ListController(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public ListController(){}

    @Transactional
    @RequestMapping(value = "/controller", method = RequestMethod.POST)
    public ModelAndView List(HttpSession session){

        String message = "";

        List<User> users = userMapper.FindAll();

        for (User u : users) {
            message += u.toString();
        }

        return new ModelAndView("/hello/view2", "message", message);
    }
}
