package com.kodem.springboot.linkedinbackend;

import com.kodem.springboot.linkedinbackend.entity.User;
import com.kodem.springboot.linkedinbackend.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory
            .getLogger(UserCommandLineRunner.class);

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
//        repository.save(new User("Sahaja",
//                "sahaja.abc@gmail.com", "sahaja"));
//        repository.save(new User("Kodem",
//                "Kodem.abc@gmail.com", "kodem"));
//        repository.save(new User("Law",
//                "law.abc@gmail.com", "law"));
//        repository.save(new User("Happy",
//                "happy.abc@gmail.com", "happy"));
//        repository.save(new User("user123",
//                "user123.abc@gmail.com", "user123"));
//        User user = new User("Hippy",
//                "hippy@gmail.com", "hiphip");

//        log.info("New user is created: " + user);

//        Optional<User> userWithIdOne = repository.findById(3);
//        log.info("User is retrieved: " + userWithIdOne);
//
//        List<User> users = repository.findAll();
//        log.info("All users: " + users);
    }
}
