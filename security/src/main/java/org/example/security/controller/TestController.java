package org.example.security.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public String test()
    {
        return "hello test";
    }
    @GetMapping("/contactUs")
    public  String contactUs()
    {
         return "contsctUs";
    }
}
