package org.example.leranjwt.controller;


import org.example.leranjwt.models.User;
import org.example.leranjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    UserService userService;
    @GetMapping("/user")
    public String user() {

        System.out.println("user");
        return "user";
    }

    @GetMapping("/list")

    public List<User> list() {
        return userService.getStore();
    }
}
