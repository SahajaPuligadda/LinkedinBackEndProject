package com.kodem.springboot.linkedinbackend.repository;

import com.kodem.springboot.linkedinbackend.entity.Skill;
import com.kodem.springboot.linkedinbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillRepository
        extends JpaRepository<Skill, Integer> {
    Skill[] findAllByUser(Optional<User> user);
    boolean existsByUserAndSkillName(Optional<User> user,
                                     String name);
    Skill findByUserAndSkillName(User user, String name);
    Skill findByUserAndId(Optional<User> user, int id);
}
