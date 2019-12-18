package com.eshop.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eshop.dao.UserDao;
import com.eshop.model.User;
import com.eshop.validate.GenderValidator;
import com.eshop.daoImpl.*;


@Controller
public class HomepageContoller {

	@Autowired
	UserDao userDao;
	
	@Autowired
	GenderValidator gendervalidate;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String HomePage(ModelMap map) {

		map.addAttribute("msg", "Welcome to home page");

		return "HomePage";
	}

@RequestMapping(value = "/getSignUpPage", method = RequestMethod.GET)
	public String registerUser(ModelMap map) {

		map.addAttribute("userObj", new User());
		map.addAttribute("btnLabel","Sign Up");

		map.addAttribute("formLabel", "SignUp Form");

			
		return "Registration";
	}	

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUserDetail(@Valid @ModelAttribute("userObj") User userObj, BindingResult result) {

		//gendervalidate.validate(userObj, result);
		if (result.hasErrors()) {
			//System.out.println("I m in if");
			ModelAndView mv = new ModelAndView("Registration");
			mv.addObject("btnLabel", "Sign Up");
			mv.addObject("formLabel", "SignUp Form");
			
		//	System.out.println(result.getAllErrors());
			
			return mv;
		} else {
			System.out.println("I m in else");
			userDao.registerUser(userObj);
			ModelAndView mv = new ModelAndView("Registration");
			mv.addObject("msg", "User has been registered succesfully. Now u can Login");
			return mv;
		}

	}

	@RequestMapping(value = "/getLoginForm", method = RequestMethod.GET)
	public String signIn()

	{
		return "Login";

	}

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/Loginform", method = RequestMethod.POST)
	public String SignInfrom(@RequestParam int userId, @RequestParam String password) {
		User obj = userDao.validateUser(userId, password);
		session.setAttribute("uobj1", obj);
		if (obj != null) {

			if (obj.getRole().equals("admin"))

			{
				return "adminLogin";

			} else if (obj.getRole().equals("customer")) {
				return "userLogin";
			}
		}

		return "Login";

	}

	@RequestMapping(value = "/getAllprofile", method = RequestMethod.GET)
	public ModelAndView getAllUserProfile() {
		List<User> users = userDao.getAllUsers();
		ModelAndView mv = new ModelAndView("ViewAllProfile");
		mv.addObject("UserObject", users);

		return mv;

	}
}
