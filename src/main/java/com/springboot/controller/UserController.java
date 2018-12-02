package com.springboot.controller;


import com.springboot.domain.User;
import com.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/user")
    public List<User> userList(){
        return userRepository.findAll();
    }

    @RequestMapping(value="/hello")
    public String hello(){
        return "hello";
    }


}
