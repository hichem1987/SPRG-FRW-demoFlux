package com.example.demo.controller;

import com.example.demo.data.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "users-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getUsersFlux(){
        return userService.getAllUsersStream();
    }
}
