package com.kodem.springboot.linkedinbackend.controller;

//import com.kodem.springboot.linkedinbackend.UserCommandLineRunner;

import com.kodem.springboot.linkedinbackend.entity.Education;
import com.kodem.springboot.linkedinbackend.entity.Profile;
import com.kodem.springboot.linkedinbackend.service.EducationRepository;
import com.kodem.springboot.linkedinbackend.service.EducationService;
import com.kodem.springboot.linkedinbackend.service.ProfileRepository;
import com.kodem.springboot.linkedinbackend.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;


@RestController
public class EducationController {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
	EducationService educationService;

	@RequestMapping(value = "/{uid}/educations",
			method = RequestMethod.GET)
	@Transactional
	public Education[] displayEducations(@PathVariable int uid)
			throws Exception {
		return educationService.getEducations(uid);
	}

	@RequestMapping(value = "/{uid}/educations/{eid}",
			method = RequestMethod.GET)
	@Transactional
	public Education displayEducation(@PathVariable int uid,
										 @PathVariable int eid)
			throws Exception {
		return educationService.getEducation(uid, eid);
	}

}
