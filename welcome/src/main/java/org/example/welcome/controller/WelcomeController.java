package org.example.welcome.controller;


import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
public class WelcomeController {


    public String welcome()
    {
        return "welcome";
    }
}
