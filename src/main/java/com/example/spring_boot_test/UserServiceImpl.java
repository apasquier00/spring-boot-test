package com.example.spring_boot_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {
    @Qualifier("jpaUserDao")
    @Autowired
    UserDao userDao;

    public UserServiceImpl(JdbcUserDao inMemoryUserDao) {
        this.userDao = inMemoryUserDao;
    }

    public User addUser(User user) {
        userDao.add(user);
        return user;
    }

    public User getUserById(@PathVariable String userId) {


        return userDao.getById(userId);
    }

    @Override
    public void deleteUser(String userId) {
        userDao.delete(userId);

    }

    @Override
    public Stream<User> getAllUsers() {
        return userDao.findAll();
    }
}
