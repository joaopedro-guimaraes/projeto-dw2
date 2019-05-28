package org.dw2Backend.controller.User;

import org.dw2Backend.entity.User;
import org.dw2Backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    public UserController(){}

    @GetMapping(value = "/usuario")
    public ResponseEntity<List<User>> SearchAll(){

        List<User> users = this.userService.SearchAll();

        if(users.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping(value = "/usuario/{id}")
    public ResponseEntity<List<User>> SearchById(@PathVariable int id){

        List<User> users = this.userService.SearchById(id);

        if(users.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(users, HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = "/usuario")
    public ResponseEntity Register(@RequestBody User user, HttpSession session){

        if(userService.Save(user)){
            session.setAttribute("user", user.getUsername());
            session.setAttribute("email", user.getEmail());

            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PutMapping(value = "/usuario")
    public ResponseEntity Update(@RequestBody User user, HttpSession session){

        if(userService.Update(user)){
            session.setAttribute("user", user.getUsername());
            session.setAttribute("email", user.getEmail());

            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @DeleteMapping(value = "/usuario")
    public ResponseEntity Delete(@RequestBody User user){

        if(userService.Delete(user)){

            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}