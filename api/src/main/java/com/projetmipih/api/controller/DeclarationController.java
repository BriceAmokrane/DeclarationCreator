package com.projetmipih.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetmipih.api.model.Declaration;
import com.projetmipih.api.service.DeclarationService;

@RestController
public class DeclarationController {

	
	@Autowired
	private DeclarationService declarationService;
	
	@GetMapping("/declarations")
	public Iterable<Declaration> getDeclarations(){
		return declarationService.getAllDeclarations();
	}
	
	
}
