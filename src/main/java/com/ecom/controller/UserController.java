package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.dao.UserDAO;
import com.ecom.model.Login;
import com.ecom.model.User;

@Controller
public class UserController {
	
	@Autowired
	UserDAO dao;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registratonMapping() {
		ModelAndView mv = new ModelAndView("register"); 
		mv.addObject("user", new User());
		return mv;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView indexMapping() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registratonSubmit(@ModelAttribute("user") User user) { 
		dao.createUser(user);
		return new ModelAndView("success","email",user.getEmail());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginMapping() {
		ModelAndView mv = new ModelAndView("login"); 
		mv.addObject("login", new Login());
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView registratonSubmit(@ModelAttribute("login") Login login) { 
		List<User> users = dao.loginUser(login);
		if(users.isEmpty()) {
			return new ModelAndView("failure","error","Login Failed , Invalid username & password");
		}
		return new ModelAndView("success","user",users.get(0));
	}
}
