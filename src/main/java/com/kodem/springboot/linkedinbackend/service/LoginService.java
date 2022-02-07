package com.kodem.springboot.linkedinbackend.service;

import com.kodem.springboot.linkedinbackend.entity.Education;
import com.kodem.springboot.linkedinbackend.entity.Profile;
import com.kodem.springboot.linkedinbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public boolean validateUser(String email, String password){
        User user = userRepository.findByEmail(email);
        //System.out.println(user);
        return user.getPassword().equals(password);
    }

    public boolean existsUser(String email, String password){
        if(!userRepository.existsUserByEmail(email)){
            return false;
        }
        return true;
    }

    public User verifyUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User createUser(String email, String password) {
        User u = new User(email, password);
        Profile p = new Profile(u, "", "",
                "", "", "Hi!",
                "https://www.clipartkey.com/mpngs/m/146-1461473_default-profile-picture-transparent.png");
        User user = userRepository.save(u);
        profileRepository.save(p);
        return user;
    }
}
