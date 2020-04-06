package com.CasaDeShow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return"LayotPrincipal";
	}
	@RequestMapping("/login")
	public String loginPage() {
		return"login";
	}
	@RequestMapping("/logot-success")
	public String logoutPage() {
		return "login";
	}
}
