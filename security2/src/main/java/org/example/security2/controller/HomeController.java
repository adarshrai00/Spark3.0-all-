package org.example.security2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {



    @GetMapping("/")
    public String Welcome() {

        return "Hello World";
    }
    @GetMapping("/user")
    public String user()
    {
      return "hii i m user";
    }
    @GetMapping("/admin")
    public String admin()
    {
        return "hii i m user";
    }
}
