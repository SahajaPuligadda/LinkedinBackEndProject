package com.kodem.springboot.linkedinbackend.service;

import com.kodem.springboot.linkedinbackend.entity.Education;
import com.kodem.springboot.linkedinbackend.entity.Skill;
import com.kodem.springboot.linkedinbackend.entity.User;
import com.kodem.springboot.linkedinbackend.repository.SkillRepository;
import com.kodem.springboot.linkedinbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private UserRepository userRepository;

    public Skill[] getSkills(int id){
        if(userRepository.existsById(id)) {
            Optional<User> user = userRepository.findById(id);
            return skillRepository.findAllByUser(user);
        }
        return null;
    }

    public Skill[] deleteSkill(int uid, int sid){
        if(userRepository.existsById(uid)
                && skillRepository.existsById(sid)) {
            Optional<User> user = userRepository.findById(uid);
            skillRepository.deleteById(sid);
            return skillRepository.findAllByUser(user);
        }
        return null;
    }

    public Skill createSkill(int uid, String name){
//        System.out.println("Skillexists : " +
//                skillRepository.existsByUserAndSkillName(
//                userRepository.findById(uid), name));
        if(userRepository.existsById(uid) &&
                !skillRepository.existsByUserAndSkillName(
                        userRepository.findById(uid), name)) {
            User user = userRepository.
                    findById(uid).orElse(null);
//            System.out.println("user: " + user);
            Skill skill = new Skill(user, name);
            skillRepository.save(skill);
            return skillRepository.findByUserAndSkillName(user, name);
        }
        return null;
    }

    public Skill getSkill(int uid, int sid){
        if(userRepository.existsById(uid)) {
            Optional<User> user = userRepository.findById(uid);
            return skillRepository.findByUserAndId(user, sid);
        }
        return null;
    }

    public Skill updateSkill(int uid, int sid, String skillName) {
        if(userRepository.existsById(uid)) {
            Optional<User> user = userRepository.findById(uid);
            Skill skill = skillRepository.findByUserAndId(user, sid);
            skill.setSkillName(skillName);
            return skillRepository.findByUserAndId(user, sid);
        }
        return null;
    }
}
