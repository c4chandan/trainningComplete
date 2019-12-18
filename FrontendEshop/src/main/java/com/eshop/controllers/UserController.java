package com.eshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eshop.dao.UserDao;
import com.eshop.model.User;


@Controller

public class UserController {
	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/DeleteUser/{uid}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable int uid) {
		User uobj = userDao.getUserById(uid);

		userDao.deleteUser(uobj);

		ModelAndView mv = new ModelAndView("ViewAllProfile");

		mv.addObject("UserObject", userDao.getAllUsers());

		return mv;

	}

	@RequestMapping(value = "/UpdateUser/{uid}", method = RequestMethod.GET)
	public ModelAndView getUpdateUser(@PathVariable int uid) {
		User userObj = userDao.getUserById(uid);

		ModelAndView mv = new ModelAndView("Registration");

		mv.addObject("userObj", userObj);

		mv.addObject("btnLabel", "Update");

		mv.addObject("formLabel", "Update Form");

		return mv;

	}

}
