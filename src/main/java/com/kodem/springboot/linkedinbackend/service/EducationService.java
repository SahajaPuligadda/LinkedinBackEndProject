package com.kodem.springboot.linkedinbackend.service;

import com.kodem.springboot.linkedinbackend.entity.Education;
import com.kodem.springboot.linkedinbackend.entity.User;
import com.kodem.springboot.linkedinbackend.repository.EducationRepository;
import com.kodem.springboot.linkedinbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private UserRepository userRepository;

    public Education[] getEducations(int id){
        if(userRepository.existsById(id)) {
            Optional<User> user = userRepository.findById(id);
            return educationRepository.findAllByUser(user);
        }
        return null;
    }

    public Education getEducation(int uid, int eid){
        if(userRepository.existsById(uid)) {
            Optional<User> user = userRepository.findById(uid);
            return educationRepository.findByUserAndId(user, eid);
        }
        return null;
    }

    public Education updateEducation(int uid, int eid, String school,
                                       String degree, String field,
                                       float grade, Date startDate,
                                       Date endDate, String desc){
        if(userRepository.existsById(uid)) {
            Optional<User> user = userRepository.findById(uid);
            Education edu = educationRepository.findByUserAndId(user, eid);
            edu.setSchool(school);
            edu.setDegree(degree);
            edu.setField(field);
            edu.setGrade(grade);
            edu.setStartDate(startDate);
            edu.setEndDate(endDate);
            edu.setDescription(desc);
            return educationRepository.findByUserAndId(user, eid);
        }
        return null;
    }

    public Education createEducation(int uid, String school,
                                       String degree, String field,
                                       float grade, Date startDate,
                                       Date endDate, String desc){
        if(userRepository.existsById(uid)) {
            User user = userRepository.findById(uid).orElse(null);
            Education edu = new Education(user, school, degree, field,
                    grade, desc, startDate, endDate);
            return educationRepository.save(edu);
        }
        return null;
    }

    public Education[] deleteEducation(int uid, int eid){
        if(userRepository.existsById(uid)
                && educationRepository.existsById(eid)) {
            Optional<User> user = userRepository.findById(uid);
            educationRepository.deleteById(eid);
            return educationRepository.findAllByUser(user);
        }
        return null;
    }

}
