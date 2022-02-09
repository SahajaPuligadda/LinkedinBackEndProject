package com.kodem.springboot.linkedinbackend.controller;

//import com.kodem.springboot.linkedinbackend.UserCommandLineRunner;

import com.kodem.springboot.linkedinbackend.entity.Experience;
import com.kodem.springboot.linkedinbackend.repository.ExperienceRepository;
import com.kodem.springboot.linkedinbackend.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;


@RestController
public class ExperienceController {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
	ExperienceService experienceService;

	@RequestMapping(value = "/{uid}/experiences",
			method = RequestMethod.GET)
	@Transactional
	public Experience[] displayExperiences(@PathVariable int uid)
			throws Exception {
		return experienceService.getExperiences(uid);
	}

	@RequestMapping(value = "/{uid}/experiences/{eid}",
			method = RequestMethod.GET)
	@Transactional
	public Experience displayExperience(@PathVariable int uid,
										 @PathVariable int eid)
			throws Exception {
		return experienceService.getExperience(uid, eid);
	}

}
