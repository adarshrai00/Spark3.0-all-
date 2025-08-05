package org.example.security.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class customUserDetailsService implements UserDetailsService {
    @Override
     public  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        String encodedPass= new BCryptPasswordEncoder().encode("admin");
    if(username.equals("admin"))
        {
             return User.withUsername("admin")
             .password(encodedPass)
            .roles("ADMIN")
             .build();
        }
        String encodedPas= new BCryptPasswordEncoder().encode("admin");
        if(username.equals("raj"))
        {
            return User.withUsername("raj")
                    .password(encodedPas)
                    .roles("USER")
                    .build();
        }
   throw new UsernameNotFoundException("User not found");

   }


}
