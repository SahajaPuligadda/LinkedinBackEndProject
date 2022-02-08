package com.kodem.springboot.linkedinbackend.service;

import com.kodem.springboot.linkedinbackend.entity.Education;
import com.kodem.springboot.linkedinbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EducationRepository
        extends JpaRepository<Education, Integer> {
    Education[] findAllByUser(Optional<User> user);
    Education findByUserAndId(Optional<User> user, int id);
}
