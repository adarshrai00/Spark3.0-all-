package org.example.greetapi1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class greetController {


    @GetMapping("/greet")
    public  String greetCo() {

        return "Hello World";
    }
}
