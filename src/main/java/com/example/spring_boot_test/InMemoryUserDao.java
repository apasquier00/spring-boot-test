package com.example.spring_boot_test;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class InMemoryUserDao implements UserDao {



    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public Stream<User> findAll() {
        return Stream.empty();
    }

    public User getById(String id) {
        return userMap.get(id);
    }

    public User add(User user) {

        userMap.put(user.getId(), user); // Store the user in the map
        return user;
    }

    @Override
    public void delete(String id) {
        userMap.remove(id);
        return;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }
}
