package com.kodem.springboot.linkedinbackend.controller;

import com.kodem.springboot.linkedinbackend.entity.User;
import com.kodem.springboot.linkedinbackend.entity.UserRegister;
import com.kodem.springboot.linkedinbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@RestController
public class UserController {
    @Autowired
    LoginService service;

	@RequestMapping(value = "/login",
			method = RequestMethod.POST)
	@Transactional
	public User toLogin(@RequestBody User user
							  ) throws Exception {
		String email = user.getEmail();
		String password = user.getPassword();
		System.out.println(email);
		System.out.println(password);
		boolean isExistsUser = service.existsUser(email, password);
		System.out.println(isExistsUser);
		User output = service.verifyUser(email, password);
		System.out.println("uc " + output);
		if(!isExistsUser) {
			throw new Exception("There is no account with this email. " +
					"Register below!");
		}
		else {
			boolean isValidUser = service.validateUser(email,
					password);
			System.out.println("isvaliduser " + isValidUser);
			if (!isValidUser) {
				throw new Exception("Invalid Credentials!") ;
			}
		}
		return output;
	}

	@RequestMapping(value = "/register",
			method = RequestMethod.POST)
	@Transactional
	public void toRegister(@RequestBody UserRegister user
	) throws Exception {
		String name = user.getName();
		String email = user.getEmail();
		String password = user.getPassword();
		boolean isExistsUser = service.existsUser(email, password);
		User new_user = null;
		if(isExistsUser) {
			throw new Exception("Account already exists!");
		}
		else {
			new_user = service.createUser(email, password, name);
		}
	}

}
