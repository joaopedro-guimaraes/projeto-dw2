package org.dw2Backend.controller;

import org.dw2Backend.entity.User;
import org.dw2Backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RestController
@Scope(value= WebApplicationContext.SCOPE_REQUEST)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    public UserController(){}

    @GetMapping(value = "/usuario")
    public ResponseEntity<List<User>> SearchAll(){

        List<User> userList = this.userService.SearchAll();

        if(userList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(userList, HttpStatus.OK);
    }

    @GetMapping(value = "/usuario/{id}")
    public ResponseEntity<List<User>> SearchById(@PathVariable int id){

        List<User> userList = this.userService.SearchById(id);

        if(userList.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(userList, HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = "/usuario")
    public ResponseEntity<User> Register(@RequestBody User user){

        if((userService.Save(user)) != null){
            return new ResponseEntity(user, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PutMapping(value = "/usuario")
    public ResponseEntity Update(@RequestBody User user){

        if(userService.Update(user)){
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