package com.kodem.springboot.linkedinbackend.controller;

//import com.kodem.springboot.linkedinbackend.UserCommandLineRunner;

import com.kodem.springboot.linkedinbackend.entity.Profile;
import com.kodem.springboot.linkedinbackend.entity.User;
import com.kodem.springboot.linkedinbackend.service.LoginService;
import com.kodem.springboot.linkedinbackend.service.ProfileRepository;
import com.kodem.springboot.linkedinbackend.service.ProfileService;
import com.kodem.springboot.linkedinbackend.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@RestController
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
	ProfileService profileService;

	@RequestMapping(value = "/{uid}/about",
			method = RequestMethod.GET)
	@Transactional
	public Profile displayProfile(@PathVariable int uid)
			throws Exception {
		return profileService.getProfile(uid);
	}

}
