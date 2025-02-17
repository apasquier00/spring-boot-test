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

    @PostMapping("/users")
    public User addUser(@RequestBody UserCreationParams params) {
        User user = new User(UUID.randomUUID().toString(), params.getEmail(), params.getPassword());
        return userService.addUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public void addUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable String userId) {
        User user = userService.getUserById(userId);
        return new UserDto(user.getId(), user.getEmail());
    }

    @GetMapping("/users")
    public List<UserDto> getAllUser() {
        try (Stream<User> users = userService.getAllUsers()) {
            // Collecte les éléments du flux dans une liste avant de les retourner
            return users.map(user -> new UserDto(user.getId(), user.getEmail()))
                    .collect(Collectors.toList());
        }}


}
