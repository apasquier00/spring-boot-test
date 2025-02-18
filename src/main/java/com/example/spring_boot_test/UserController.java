package com.example.spring_boot_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;
    RandomUser randomUser = new RandomUser();


    @PostMapping("/users")
    public User addUser(@RequestBody UserCreationParams params) {
        User user = new User(UUID.randomUUID().toString(), params.getEmail(), params.getPassword());
        return userService.addUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable String userId) {
        User user = userService.getUserById(userId);
        return new UserDto(user.getId(), user.getEmail());
    }

    @PostMapping("/users/{userNbr}")
    public void makeRandomUsers(@PathVariable String userNbr) {
        for (int i = 0; i < Integer.parseInt(userNbr); i++) {
            User user = new User(UUID.randomUUID().toString(), randomUser.randomEmail(), randomUser.randomPassword());
            userService.addUser(user);

    }
    }

    @GetMapping("/users")
    public List<UserDto> getAllUser() {
        try (Stream<User> users = userService.getAllUsers()) {
            // Collecte les éléments du flux dans une liste avant de les retourner
            return users.map(user -> new UserDto(user.getId(), user.getEmail()))
                    .collect(Collectors.toList());
        }}



}
