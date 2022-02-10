package com.kodem.springboot.linkedinbackend.controller;

import com.kodem.springboot.linkedinbackend.entity.Experience;
import com.kodem.springboot.linkedinbackend.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;


@RestController
public class ExperienceController {

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

	@RequestMapping(value = "/{uid}/experiences/{eid}/edit",
			method = RequestMethod.PUT)
	@Transactional
	public Experience editExperience(@PathVariable int uid,
										@PathVariable int eid,
										@RequestBody Experience exp)
			throws Exception {

		System.out.println("Experience Details: " + exp);
		String title = exp.getTitle();
		String empType = exp.getEmpType();
		String companyName = exp.getCompanyName();
		String location = exp.getLocation();
		Date startDate = exp.getStartDate();
		Date endDate = exp.getEndDate();
		String desc = exp.getDescription();

		return experienceService.updateExperience(uid, eid, title, empType,
				companyName, location, startDate, endDate, desc);
	}

	@RequestMapping(value = "/{uid}/experiences/new",
			method = RequestMethod.POST)
	@Transactional
	public Experience addExperience(@PathVariable int uid,
									 @RequestBody Experience exp)
			throws Exception {

		System.out.println("Experience Details: " + exp);
		String title = exp.getTitle();
		String empType = exp.getEmpType();
		String companyName = exp.getCompanyName();
		String location = exp.getLocation();
		Date startDate = exp.getStartDate();
		Date endDate = exp.getEndDate();
		String desc = exp.getDescription();

		return experienceService.createExperience(uid, title, empType,
				companyName, location, startDate, endDate, desc);
	}

	@RequestMapping(value = "/{uid}/experiences/{eid}/delete",
			method = RequestMethod.DELETE)
	@Transactional
	public Experience[] deleteExperience(@PathVariable int uid,
							   @PathVariable int eid)
			throws Exception {
		return experienceService.deleteExperience(uid, eid);
	}

}
