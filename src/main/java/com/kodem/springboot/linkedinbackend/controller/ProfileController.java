package com.kodem.springboot.linkedinbackend.controller;

//import com.kodem.springboot.linkedinbackend.UserCommandLineRunner;

import com.kodem.springboot.linkedinbackend.entity.Profile;
import com.kodem.springboot.linkedinbackend.repository.ProfileRepository;
import com.kodem.springboot.linkedinbackend.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@RestController
public class ProfileController {

    @Autowired
	ProfileService profileService;

	@RequestMapping(value = "/{uid}/about",
			method = RequestMethod.GET)
	@Transactional
	public Profile displayProfile(@PathVariable int uid)
			throws Exception {
		return profileService.getProfile(uid);
	}

	@RequestMapping(value = "/{uid}/about/edit-about",
			method = RequestMethod.PUT)
	@Transactional
	public Profile editAbout(@PathVariable int uid,
							 @RequestBody Profile profile)
			throws Exception {
		String about = profile.getAbout();
		return profileService.updateAbout(uid, about);
	}

	@RequestMapping(value = "/{uid}/about/edit-bio",
			method = RequestMethod.PUT)
	@Transactional
	public Profile editBio(@PathVariable int uid,
							 @RequestBody Profile profile)
			throws Exception {
		System.out.println("Profile Details: " + profile);
		String name = profile.getName();
		String tag = profile.getTagline();
		String workplace = profile.getWorkplace();
		String location = profile.getLocation();
		String dpPath = profile.getPhoto();
		return profileService.updateBio(uid, name, tag,
				workplace, location, dpPath);
	}

}
