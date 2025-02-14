package com.example.spring_boot_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserServiceImpl implements UserService {
    @Qualifier("jdbcUserDao")
    @Autowired
    UserDao userDao;

    public UserServiceImpl(JdbcUserDao inMemoryUserDao) {
        this.userDao = inMemoryUserDao;
    }

    public User addUser(User user) {
        userDao.addUpdate(user);
        return user;
    }

    public User getUserById(@PathVariable String userId) {


        return userDao.getById(userId);
    }
}
