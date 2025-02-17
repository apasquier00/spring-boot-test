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
        //makeRandomUsers();
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

//    public void makeRandomUsers() {
//        for (int i = 0; i < 10; i++) {
//            User user = new User(UUID.randomUUID().toString(), randomEmail(), randomPassword());
//            userService.addUser(user);
//        }
//    }
//    public String randomPassword() {
//        StringBuilder name = new StringBuilder();
//        for (int i = 0; i < randomInt(10); i++){
//            name.append(convertIntToString(randomInt(25)));
//        }
//        return name.toString();
//    }
//
//    public String randomEmail() {
//        return randomPassword() +
//                "@" +
//                randomPassword() +
//                randomExtension();
//    }
//
//    public int randomInt(int i) {
//        return (int) (1+(Math.random())*i);
//    }
//    public String convertIntToString(int i) {
//        String[] alphabet = {"da","bi","ce","doo","er","fa","go","he","ib","je","ka","lo","mi","ne","or","pi","qa","ry","se","ta","bu","vy","wo","xy","yo","za"};
//        return alphabet[i];
//    }
//    public String randomExtension(){
//        String[] extension = {".fr", ".org", ".ru", ".en", ".com"};
//        return extension[randomInt(4)];
//    }
}
