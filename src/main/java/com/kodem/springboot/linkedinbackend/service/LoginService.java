package com.kodem.springboot.linkedinbackend.service;

import com.kodem.springboot.linkedinbackend.entity.Profile;
import com.kodem.springboot.linkedinbackend.entity.User;
import com.kodem.springboot.linkedinbackend.repository.ProfileRepository;
import com.kodem.springboot.linkedinbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userRepository.existsUserByEmail(email);
    }

    public User verifyUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User createUser(String email, String password, String name) {
        User u = new User(email, password);
        Profile p = new Profile(u, name, "Enter HeadLine",
                "Enter current workplace", "Enter current location",
                "https://www.pngarts.com/files/10/Default-Profile-Picture-Download-PNG-Image.png",
                "Hi!");
        User user = userRepository.save(u);
        profileRepository.save(p);
        return user;
    }
}
