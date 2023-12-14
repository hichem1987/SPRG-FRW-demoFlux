package com.example.demo.service;

import com.example.demo.data.User;
import com.example.demo.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List getAllUsers() {
        return userDao.getAllUsers();
    }

    public Flux<User> getAllUsersStream() {
        return userDao.getAllUsersStream();
    }
}
