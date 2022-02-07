package com.kodem.springboot.linkedinbackend.service;

import com.kodem.springboot.linkedinbackend.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository
        extends JpaRepository<Education, Integer> {
}
