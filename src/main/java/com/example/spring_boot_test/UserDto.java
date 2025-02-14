package com.example.spring_boot_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public class UserDto {
    public final String id;
    public final String email;

    public UserDto(String id,String email) {
        this.id = id;
        this.email = email;
    }
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
