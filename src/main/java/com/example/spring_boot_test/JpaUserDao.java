package com.example.spring_boot_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class JpaUserDao implements UserDao {

    @Autowired
    UserEntityRepository userEntityRepository;

    public JpaUserDao() {
    }

    public Stream<User> findAll() {
        List<UserEntity> usersEntity = userEntityRepository.findAll();
        return listUEToStreamU(usersEntity);
    }

    public User getById(String id) {
        Optional<UserEntity> optUserEntity = userEntityRepository.findById(id);
        UserEntity userEntity = optUserEntity.orElse(null);
        User user = convertUEtoU(userEntity);
        return user;
    }

    public User add(User user) {
        UserEntity userEntity = convertUtoUE(user);
        userEntityRepository.save(userEntity);
        return user;
    }

    public void delete(String id) {
        userEntityRepository.deleteById(id);

    }

    public UserEntity convertUtoUE(User user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(user.getId());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }
    public User convertUEtoU(UserEntity userEntity) {
        User user = new User(null,null,null);

        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        return user;
    }
    public Stream<User> listUEToStreamU(List<UserEntity> userEntityList) {
        Stream<UserEntity> userEntityStream = userEntityList.stream();
        return userEntityStream.map(this::convertUEtoU);
    }
}
