package com.ptithcm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {
	
	@RequestMapping("login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("register")
	public String showaddInformation() {
		return "register";
	}
//	@RequestMapping("/checkLogin")
//	public String checkLogin() {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth!=null)
//		{
//			if (auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_A")))
//				return "redirect:/admin";	
//			else
//			if (auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_E")))
//				return "redirect:/trang-chu";
//			else
//				return "redirect:/404";
//		}
//		return "redirect:/404";
//	}
}
