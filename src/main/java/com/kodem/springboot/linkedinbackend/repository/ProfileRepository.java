package com.kodem.springboot.linkedinbackend.repository;

import com.kodem.springboot.linkedinbackend.entity.Profile;
import com.kodem.springboot.linkedinbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository
        extends JpaRepository<Profile, Integer> {
    Profile findByUser(Optional<User> user);
}
