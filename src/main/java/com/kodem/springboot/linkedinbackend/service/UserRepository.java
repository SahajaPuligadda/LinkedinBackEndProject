package com.kodem.springboot.linkedinbackend.service;

import com.kodem.springboot.linkedinbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository
        extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    boolean existsUserByEmail(String email);
    User findByEmailAndPassword(String email, String password);

}
