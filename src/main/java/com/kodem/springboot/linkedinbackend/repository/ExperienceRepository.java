package com.kodem.springboot.linkedinbackend.repository;

import com.kodem.springboot.linkedinbackend.entity.Education;
import com.kodem.springboot.linkedinbackend.entity.Experience;
import com.kodem.springboot.linkedinbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExperienceRepository
        extends JpaRepository<Experience, Integer> {
    Experience[] findAllByUser(Optional<User> user);
    Experience findByUserAndId(Optional<User> user, int id);
}
