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
        User user = new User(UUID.randomUUID().toString(), params.getEmail(), params.getPassword());
        return userService.addUser(user);
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable String userId) {
        User user = userService.getUserById(userId);
        return new UserDto(user.getId(), user.getEmail());
    }

}
