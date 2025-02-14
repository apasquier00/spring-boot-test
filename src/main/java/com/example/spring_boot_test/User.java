package com.example.spring_boot_test;

import java.util.UUID;

public class User {

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String id;
    private String email;
    private String password;
    public User(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
