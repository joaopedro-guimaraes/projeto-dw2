package org.dw2Backend.controller.User;

import org.dw2Backend.entity.User;
import org.dw2Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService = userService;
    }

    public LoginController() {}

    @Transactional
    @PostMapping
    @RequestMapping(value = "/autenticar")
    public ModelAndView Login(@Validated @RequestBody User user, HttpSession session){

        if(userService.Authenticate(user)) {
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
