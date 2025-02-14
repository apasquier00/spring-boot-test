package com.example.spring_boot_test;

import jakarta.validation.constraints.NotNull;

import java.util.stream.Stream;

public interface UserDao {

    @NotNull Stream<User> findAll();
    User getById(@NotNull String id);
    void addUpdate(@NotNull User user);
    void delete(@NotNull String id);
}
