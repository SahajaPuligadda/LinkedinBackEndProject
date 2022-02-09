package com.kodem.springboot.linkedinbackend.service;

import com.kodem.springboot.linkedinbackend.entity.Profile;
import com.kodem.springboot.linkedinbackend.entity.User;
import com.kodem.springboot.linkedinbackend.repository.ProfileRepository;
import com.kodem.springboot.linkedinbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    public Profile getProfile(int id){
        if(userRepository.existsById(id)) {
            Optional<User> user = userRepository.findById(id);
            return profileRepository.findByUser(user);
        }
        return null;
    }

    public Profile updateAbout(int id, String about){
        if(userRepository.existsById(id)) {
            Optional<User> user = userRepository.findById(id);
            Profile profile = profileRepository.findByUser(user);
            profile.setAbout(about);
            return profileRepository.findByUser(user);
        }
        return null;
    }

    public Profile updateBio(int id, String name, String tag,
                             String workplace, String location,
                             String dpPath) {
        if(userRepository.existsById(id)) {
            Optional<User> user = userRepository.findById(id);
            Profile profile = profileRepository.findByUser(user);
            profile.setName(name);
            profile.setTagline(tag);
            profile.setWorkplace(workplace);
            profile.setLocation(location);
            profile.setPhoto(dpPath);
            return profileRepository.findByUser(user);
        }
        return null;
    }
}
