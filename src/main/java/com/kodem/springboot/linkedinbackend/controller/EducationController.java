package com.kodem.springboot.linkedinbackend.controller;

import com.kodem.springboot.linkedinbackend.entity.Education;
import com.kodem.springboot.linkedinbackend.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;


@RestController
public class EducationController {

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

	@RequestMapping(value = "/{uid}/educations/{eid}/edit",
			method = RequestMethod.PUT)
	@Transactional
	public Education editEducation(@PathVariable int uid,
									 @PathVariable int eid,
									 @RequestBody Education edu)
			throws Exception {

		System.out.println("Education Details: " + edu);
		String school = edu.getSchool();
		String degree = edu.getDegree();
		String field = edu.getField();
		float grade = edu.getGrade();
		Date startDate = edu.getStartDate();
		Date endDate = edu.getEndDate();
		String desc = edu.getDescription();

		return educationService.updateEducation(uid, eid, school, degree,
				field, grade, startDate, endDate, desc);
	}

	@RequestMapping(value = "/{uid}/educations/new",
			method = RequestMethod.POST)
	@Transactional
	public Education addEducation(@PathVariable int uid,
									@RequestBody Education edu)
			throws Exception {

		System.out.println("Education Details: " + edu);
		String school = edu.getSchool();
		String degree = edu.getDegree();
		String field = edu.getField();
		float grade = edu.getGrade();
		Date startDate = edu.getStartDate();
		Date endDate = edu.getEndDate();
		String desc = edu.getDescription();

		return educationService.createEducation(uid, school, degree,
				field, grade, startDate, endDate, desc);
	}

	@RequestMapping(value = "/{uid}/educations/{eid}/delete",
			method = RequestMethod.DELETE)
	@Transactional
	public Education[] deleteEducation(@PathVariable int uid,
										 @PathVariable int eid)
			throws Exception {
		return educationService.deleteEducation(uid, eid);
	}


}
