package org.example.welcome.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient
public class GreetFiegnClient {

    @GetMapping("/greet")
    public String invokeGreetApi();
}
