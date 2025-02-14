package com.example.spring_boot_test;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface UserService {
    User addUser(User user);
    User getUserById(String userId);
}
