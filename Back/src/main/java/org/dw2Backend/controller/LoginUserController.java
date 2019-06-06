package org.dw2Backend.controller;

import org.dw2Backend.entity.User;
import org.dw2Backend.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class LoginUserController {

    private UserService userService;

    @Autowired
    public LoginUserController(UserService userService){
        this.userService = userService;
    }

    public LoginUserController() {}

    @PostMapping(value = "/login")
    public ResponseEntity Login(@RequestBody User user, HttpSession session){
        user = userService.Authenticate(user);

        if(user != null) {
            session.setAttribute("user", user.getUsername());
            session.setAttribute("email", user.getEmail());

            return new ResponseEntity(user ,HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/sair")
    public ResponseEntity Logout(HttpSession session){

        if(!session.isNew()) {
            session.removeAttribute("user");
            session.invalidate();
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
