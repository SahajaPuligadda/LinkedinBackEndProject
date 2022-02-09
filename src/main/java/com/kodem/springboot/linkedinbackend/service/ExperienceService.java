package com.kodem.springboot.linkedinbackend.service;

import com.kodem.springboot.linkedinbackend.entity.Experience;
import com.kodem.springboot.linkedinbackend.entity.User;
import com.kodem.springboot.linkedinbackend.repository.ExperienceRepository;
import com.kodem.springboot.linkedinbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private UserRepository userRepository;

    public Experience[] getExperiences(int id){
//        System.out.println(userRepository.existsById(id));
        if(userRepository.existsById(id)) {
            Optional<User> user = userRepository.findById(id);
//            System.out.println(user);
            return experienceRepository.findAllByUser(user);
        }
        return null;
    }

    public Experience getExperience(int uid, int eid){
//        System.out.println(userRepository.existsById(id));
        if(userRepository.existsById(uid)) {
            Optional<User> user = userRepository.findById(uid);
//            System.out.println(user);
            return experienceRepository.findByUserAndId(user, eid);
        }
        return null;
    }
}
