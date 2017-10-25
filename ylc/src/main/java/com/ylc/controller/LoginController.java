package com.ylc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ylc.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("home")
	public String getHome() {
		return "home";
	}

	@RequestMapping("login")
	public ModelAndView getLoginForm(
			@RequestParam(required = false) String authfailed, String logout) {
		String message = "";
		System.err
				.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		if (authfailed != null) {
			message = "Invalid username/password, try again !";
		} else if (logout != null) {
			message = "Logged Out successfully, login again to continue !";
		}
		return new ModelAndView("login", "message", message);
	}

	@RequestMapping("profile")
	public String geProfilePage() {
		return "profile";
	}

	@RequestMapping("userHome")
	public ModelAndView getUserHomePage(HttpServletRequest request) {
		String userID=SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(userID);
		if("anonymousUser".equalsIgnoreCase(userID)){
			//request.setAttribute("message", "Please login...");
			return new ModelAndView("login", "message", "Please login...");
			
		}
		else
			return new ModelAndView("home") ;
	}

}
