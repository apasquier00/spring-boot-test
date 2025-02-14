package com.example.spring_boot_test;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface UserService {
    User addUser(UserCreationParams params);
    UserDto getUserById(UUID userId);
}
