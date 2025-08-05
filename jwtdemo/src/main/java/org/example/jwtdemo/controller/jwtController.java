package org.example.jwtdemo.controller;


import io.jsonwebtoken.Jwts;
import org.example.jwtdemo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static javax.crypto.Cipher.SECRET_KEY;
import static org.example.jwtdemo.util.JwtUtil.SECRET;

@RestController
@RequestMapping
public class jwtController {

    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/generate-Token")
    public String generateToken(@RequestParam String username, @RequestParam String password) {
         if("admin".equals(username) && "admin".equals(password)) {
            return  jwtUtil.generateToken(username);
         }
         else
         {
             return "Invalid username or password";
         }

    }

    @GetMapping
     public String fundTransfer(@RequestHeader(value="Authorization",required=false) String authorizationHeader) {
        if (authorizationHeader == null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            if(jwtUtil.validateToken(token))
            {
               return "success";
            }
        }
        return "Invalid Authorization";
    }


}
