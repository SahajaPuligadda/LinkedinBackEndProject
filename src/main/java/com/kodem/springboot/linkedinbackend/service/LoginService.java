package com.kodem.springboot.linkedinbackend.service;

import com.kodem.springboot.linkedinbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(String email, String password){
        if(!userRepository.existsUserByEmail(email)){
            return false;
        }
        User user = userRepository.findByEmail(email);
        System.out.println(user);
        return user.getPassword().equals(password);
    }
}
