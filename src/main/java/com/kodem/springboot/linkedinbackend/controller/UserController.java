package com.kodem.springboot.linkedinbackend.controller;

//import com.kodem.springboot.linkedinbackend.UserCommandLineRunner;
import com.kodem.springboot.linkedinbackend.entity.User;
import com.kodem.springboot.linkedinbackend.service.LoginService;
import com.kodem.springboot.linkedinbackend.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcome(ModelMap model, @RequestParam String email, @RequestParam String password) {
//		String email = user.getEmail();
//		String password = user.getPassword();
		boolean isValidUser = service.validateUser(email, password);
		if(!isValidUser) {
			model.put("errorMessage", "Invalid Credentials!");
			return "login";
		}
		User user1 = userRepository.findByEmail(email);
		model.put("email", user1.getEmail());
		return "welcome";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String showLogout(ModelMap model) {
		model.put("errorMessage", "Logged out successfully!!");
		return "redirect:/login";
	}
}
