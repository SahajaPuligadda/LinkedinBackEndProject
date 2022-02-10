package com.kodem.springboot.linkedinbackend.service;

import com.kodem.springboot.linkedinbackend.entity.Experience;
import com.kodem.springboot.linkedinbackend.entity.User;
import com.kodem.springboot.linkedinbackend.repository.ExperienceRepository;
import com.kodem.springboot.linkedinbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Experience updateExperience(int uid, int eid, String title,
                                       String empType, String companyName,
                                       String location, Date startDate,
                                       Date endDate, String desc){
        if(userRepository.existsById(uid)) {
            Optional<User> user = userRepository.findById(uid);
            Experience exp = experienceRepository.findByUserAndId(user, eid);
            exp.setTitle(title);
            exp.setCompanyName(companyName);
            exp.setLocation(location);
            exp.setEmpType(empType);
            exp.setStartDate(startDate);
            exp.setEndDate(endDate);
            exp.setDescription(desc);
            return experienceRepository.findByUserAndId(user, eid);
        }
        return null;
    }

    public Experience createExperience(int uid, String title,
                                       String empType, String companyName,
                                       String location, Date startDate,
                                       Date endDate, String desc){
        if(userRepository.existsById(uid)) {
            User user = userRepository.findById(uid).orElse(null);
            Experience exp = new Experience(user, title, empType, companyName,
                    location, desc, startDate, endDate);
            return experienceRepository.save(exp);
        }
        return null;
    }

    public Experience[] deleteExperience(int uid, int eid){
        if(userRepository.existsById(uid)
                && experienceRepository.existsById(eid)) {
            Optional<User> user = userRepository.findById(uid);
            experienceRepository.deleteById(eid);
            return experienceRepository.findAllByUser(user);
        }
        return null;
    }

}
