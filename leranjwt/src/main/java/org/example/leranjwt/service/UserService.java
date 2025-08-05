package org.example.leranjwt.service;


import org.example.leranjwt.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store=new ArrayList<>();

    public  UserService(){

        store.add(new User(UUID.randomUUID().toString(),"John","john@example.com"));
        store.add(new User(UUID.randomUUID().toString(),"Jane","jane@example.com"));
        store.add(new User(UUID.randomUUID().toString(),"Jack","jack@example.com"));
    }

    public List<User> getStore() {
        return store;
    }
}

