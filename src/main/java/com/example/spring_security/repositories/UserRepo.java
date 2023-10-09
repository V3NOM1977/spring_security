package com.example.spring_security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_security.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

}
