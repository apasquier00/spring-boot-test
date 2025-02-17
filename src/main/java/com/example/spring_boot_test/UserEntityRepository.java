package com.example.spring_boot_test;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {
}
