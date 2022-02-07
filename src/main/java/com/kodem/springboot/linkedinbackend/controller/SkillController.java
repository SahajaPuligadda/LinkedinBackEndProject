package com.kodem.springboot.linkedinbackend.controller;

//import com.kodem.springboot.linkedinbackend.UserCommandLineRunner;

import com.kodem.springboot.linkedinbackend.entity.Profile;
import com.kodem.springboot.linkedinbackend.entity.Skill;
import com.kodem.springboot.linkedinbackend.service.ProfileRepository;
import com.kodem.springboot.linkedinbackend.service.ProfileService;
import com.kodem.springboot.linkedinbackend.service.SkillRepository;
import com.kodem.springboot.linkedinbackend.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;


@RestController
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
	SkillService skillService;

	@RequestMapping(value = "/{uid}/skills",
			method = RequestMethod.GET)
	@Transactional
	public Skill[] displayProfile(@PathVariable int uid)
			throws Exception {
		return skillService.getSkills(uid);
	}

}
