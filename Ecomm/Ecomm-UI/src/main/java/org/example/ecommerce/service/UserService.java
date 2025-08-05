package org.example.ecommerce.service;

import org.example.ecommerce.model.User;
import org.example.ecommerce.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User registerUser(User user) {
        return userRepository.save(user);


    }


    public User LoginUser(String Email, String password) {

          User byEmail= userRepository.findByEmail(Email);
          if(byEmail != null && byEmail.getPassword().equals(password)) {
              return byEmail;

          }

          return null;
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }
}
