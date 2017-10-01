package com.yosri.khalfa.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping(value= "/login")
	public String login() {
		return"login";
	}
	
	@RequestMapping(value="/403")
	public String accessDenied() {
		return"403";
	}
	
	
}
