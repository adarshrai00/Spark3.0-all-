package org.example.ecommerce.controller;


import org.example.ecommerce.model.User;
import org.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody  User user )
    {
         return  userService.registerUser(user);
    }


    @PostMapping("/login")
    public User LoginUser(@RequestBody User user)
    {
         return   userService.LoginUser(user.getEmail(),user.getPassword());
    }

    @GetMapping
    private List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
}
