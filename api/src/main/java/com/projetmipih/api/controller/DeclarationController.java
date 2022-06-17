package com.projetmipih.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/createDeclaration")
	public Declaration createDeclaration(@RequestBody Declaration declaration) {
		return declarationService.saveDeclaration(declaration);
	}
	
	@GetMapping("/declaration/{id}")
	public Optional<Declaration> getDeclaration(@PathVariable("id") Long id) {
		return declarationService.getDeclaration(id);
	}
	
	@DeleteMapping("/declarationdelete/{id}")
	public void deleteDeclaration(@PathVariable("id") Long id) {
		declarationService.deleteDeclaration(id);
	}
	
}
