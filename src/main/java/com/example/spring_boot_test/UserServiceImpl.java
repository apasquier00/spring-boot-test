package com.example.spring_boot_test;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final Map<UUID, User> userMap = new HashMap<>();

    public User addUser(UserCreationParams params) {
        UUID userId = UUID.randomUUID(); // Generate a new UUID for the user
        User user = new User();
        user.setId(userId);
        user.setEmail(params.getEmail());
        user.setPassword(params.getPassword());
        userMap.put(userId, user); // Store the user in the map
        return user;
    }

    public UserDto getUserById(@PathVariable UUID userId) {
        User user = userMap.get(userId);

        if (user != null) {
            // Convert User to UserDto
            return new UserDto(user.getId(), user.getEmail());
        } else {
            // Handle case where the user is not found (return null or throw an exception)
            return null; // Or throw a custom exception like UserNotFoundException
        }
    }
}
