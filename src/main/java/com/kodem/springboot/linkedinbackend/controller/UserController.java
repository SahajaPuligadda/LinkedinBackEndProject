package com.kodem.springboot.linkedinbackend.controller;

//import com.kodem.springboot.linkedinbackend.UserCommandLineRunner;
import com.kodem.springboot.linkedinbackend.entity.User;
import com.kodem.springboot.linkedinbackend.service.LoginService;
import com.kodem.springboot.linkedinbackend.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    LoginService service;

//    @GetMapping("/users")
//    public String listAll(ModelMap model) {
//        List<User> users = userRepository.findAll();
//        model.addAttribute("listUsers", users);
//        return "users";
//    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String showLoginPage() {
//		return "login";
//	}

	@RequestMapping(value = "/login",
			method = RequestMethod.POST)
	@Transactional
	public User toLogin(ModelMap model,
							  @RequestBody User user
							  ) throws Exception {
		String email = user.getEmail();
		String password = user.getPassword();
		boolean isExistsUser = service.existsUser(email, password);
		User output = service.verifyUser(email, password);
		if(!isExistsUser) {
			throw new Exception("There is no account with this email. " +
					"Register below!");
		}
		else {
			boolean isValidUser = service.validateUser(email,
					password);
			if (!isValidUser) {
				throw new Exception("Invalid Credentials!") ;
			}
		}
		return output;
	}

	@RequestMapping(value = "/register",
			method = RequestMethod.POST)
	@Transactional
	public void toRegister(ModelMap model,
						@RequestBody User user
	) throws Exception {
		String email = user.getEmail();
		String password = user.getPassword();
		boolean isExistsUser = service.existsUser(email, password);
		User new_user = null;
		if(isExistsUser) {
			throw new Exception("Account already exists!");
		}
		else {
			new_user = service.createUser(email, password);
			//throw new Exception(String.valueOf(new_user));
		}
		//return new_user;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String showLogout(ModelMap model) {
		model.put("errorMessage", "Logged out successfully!!");
		return "redirect:/login";
	}
}
