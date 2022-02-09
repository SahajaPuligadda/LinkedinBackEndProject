package com.kodem.springboot.linkedinbackend.service;

import com.kodem.springboot.linkedinbackend.entity.Education;
import com.kodem.springboot.linkedinbackend.entity.User;
import com.kodem.springboot.linkedinbackend.repository.EducationRepository;
import com.kodem.springboot.linkedinbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private UserRepository userRepository;

    public Education[] getEducations(int id){
//        System.out.println(userRepository.existsById(id));
        if(userRepository.existsById(id)) {
            Optional<User> user = userRepository.findById(id);
//            System.out.println(user);
            return educationRepository.findAllByUser(user);
        }
        return null;
    }

    public Education getEducation(int uid, int eid){
//        System.out.println(userRepository.existsById(id));
        if(userRepository.existsById(uid)) {
            Optional<User> user = userRepository.findById(uid);
//            System.out.println(user);
            return educationRepository.findByUserAndId(user, eid);
        }
        return null;
    }
}
