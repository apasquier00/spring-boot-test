package com.example.spring_boot_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/users")
    public User addUser(@RequestBody UserCreationParams params) {
        return userService.addUser(params);
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable UUID userId) {
        return userService.getUserById(userId);
    }

}
