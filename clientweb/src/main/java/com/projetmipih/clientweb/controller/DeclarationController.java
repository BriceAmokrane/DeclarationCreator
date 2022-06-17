package com.projetmipih.clientweb.controller;

import org.springframework.stereotype.Controller;

@Controller
public class DeclarationController {

	
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
