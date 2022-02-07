package com.kodem.springboot.linkedinbackend.service;

import com.kodem.springboot.linkedinbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(String email, String password){
        User user = userRepository.findByEmail(email);
        System.out.println(user);
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
        User user = userRepository.save(new User(email, password));
        return user;
    }
}
