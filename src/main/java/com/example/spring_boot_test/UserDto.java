package com.example.spring_boot_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public class UserDto {
    public final UUID id;
    public final String email;

    public UserDto(UUID id,String email) {
        this.id = id;
        this.email = email;
    }
    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
