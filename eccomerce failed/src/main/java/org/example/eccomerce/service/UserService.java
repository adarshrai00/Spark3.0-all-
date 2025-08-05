package org.example.eccomerce.service;

import org.example.eccomerce.model.User;
import org.example.eccomerce.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User loginUser(String email, String password) {
        User user= userRepository.findByEmail(email);

        if(user!=null && user.getPassword().equals(password))
        {
            return user;
        }

        else return null;
    }

    public User registerUser(User user) {

        return userRepository.save(user);




    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
