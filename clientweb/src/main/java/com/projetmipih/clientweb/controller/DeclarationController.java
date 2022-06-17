package com.projetmipih.clientweb.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projetmipih.clientweb.model.Declaration;
import com.projetmipih.clientweb.service.DeclarationService;

@Controller
public class DeclarationController {
	
	@Autowired
	private DeclarationService declarationService;

	
	@GetMapping("/")
	public String home(Model model) {
		Iterable<Declaration> listeDeclarations = declarationService.getDeclarations();
		model.addAttribute("declarations",listeDeclarations);
		return "home";
	}
	
	@GetMapping("/deleteDeclaration/{id}")
	public ModelAndView deleteDeclaration(@PathVariable("id") Long id) {
	    declarationService.deleteDeclaration(id);
	    return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/createDeclaration")
	public String form(Model model) {
		Declaration e = new Declaration();
		model.addAttribute("declaration", e);
		return "form";
	}
	
	@PostMapping("/saveDeclaration")
	public ModelAndView saveDeclaration(@ModelAttribute Declaration declaration) {
		if(declaration.getContenu().isEmpty() || declaration.getIntitule().isEmpty() || declaration.getNomEmploye().isEmpty() || declaration.getPrenomEmploye().isEmpty()) {
			return new ModelAndView("redirect:/createDeclaration");
		} else {
			Date date = new Date();
			declaration.setDate(date);
			declarationService.saveDeclaration(declaration);
			return new ModelAndView("redirect:/");
		}
	}
	
	@GetMapping("/viewDeclaration/{id}")
	public String viewDeclaration(@PathVariable("id") Long id, Model model) {
		Declaration inter = declarationService.getDeclaration(id);
		model.addAttribute("declarationavoir", inter);
		return "vuedetaillee";
	}
	
	
}
