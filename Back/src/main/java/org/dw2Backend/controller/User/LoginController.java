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
@RequestMapping(value = "/login")
public class LoginController {

    private UserMapper userMapper;

    @Autowired
    public LoginController(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public LoginController() {}

    @Transactional
    @RequestMapping(value = "/autenticar", method = RequestMethod.POST)
    public ModelAndView Login(User user, HttpSession session){

        if(userMapper.Authenticate(user)) {
            String messageSuccess = "Welcome!! Usuário logado com sucesso.";
            session.setAttribute("user", user.getUsername());
            session.setAttribute("email", user.getEmail());

            return new ModelAndView("/hello/view", "message", messageSuccess);
        }

        String messageFail = "Login não permitido!";
        return new ModelAndView("/hello/view2", "message", messageFail);
    }

    @Transactional
    @RequestMapping(value = "/sair", method = RequestMethod.POST)
    public ModelAndView Logout(HttpSession session){

        if(!session.isNew()) {
            session.removeAttribute("user");
            session.invalidate();
        }

        String messageFail = "Saiu do sistema!";
        return new ModelAndView("/hello/view3", "message", messageFail);
    }
}
