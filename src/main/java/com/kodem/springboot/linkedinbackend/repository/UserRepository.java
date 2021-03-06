package com.kodem.springboot.linkedinbackend.repository;

import com.kodem.springboot.linkedinbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    boolean existsUserByEmail(String email);
    User findByEmailAndPassword(String email, String password);

}
