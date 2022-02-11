package com.kodem.springboot.linkedinbackend.controller;

import com.kodem.springboot.linkedinbackend.entity.Skill;
import com.kodem.springboot.linkedinbackend.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@RestController
public class SkillController {

    @Autowired
	SkillService skillService;

	@RequestMapping(value = "/{uid}/skills",
			method = RequestMethod.GET)
	@Transactional
	public Skill[] displaySkills(@PathVariable int uid)
			throws Exception {
		return skillService.getSkills(uid);
	}

	@RequestMapping(value = "/{uid}/skills/{sid}",
			method = RequestMethod.DELETE)
	@Transactional
	public Skill[] deleteSkill(@PathVariable int uid,
								  @PathVariable int sid)
			throws Exception {
		return skillService.deleteSkill(uid, sid);
	}

	@RequestMapping(value = "/{uid}/skills/new",
			method = RequestMethod.POST)
	@Transactional
	public Skill createSkill(@PathVariable int uid,
							 @RequestBody Skill skill)
			throws Exception {
		String name = skill.getSkillName();
		System.out.println(name);
		Skill createdSkill = skillService.createSkill(uid, name);
		if(createdSkill == null)
			throw new Exception("Skill name already exists!");
		return createdSkill;
	}

	@RequestMapping(value = "/{uid}/skills/{sid}",
			method = RequestMethod.GET)
	@Transactional
	public Skill displaySkill(@PathVariable int uid,
									  @PathVariable int sid)
			throws Exception {
		return skillService.getSkill(uid, sid);
	}

	@RequestMapping(value = "/{uid}/skills/{sid}/edit",
			method = RequestMethod.PUT)
	@Transactional
	public Skill editSkill(@PathVariable int uid,
								   @PathVariable int sid,
								   @RequestBody Skill skill)
			throws Exception {

		System.out.println("Skill Details: " + skill);
		String skillName = skill.getSkillName();

		return skillService.updateSkill(uid, sid, skillName);
	}

}
