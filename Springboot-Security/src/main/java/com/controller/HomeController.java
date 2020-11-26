package com.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String Home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/login")
	public String Login()
	{
		return "login.jsp";
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal principal)
	{
		return principal;
	}
}
