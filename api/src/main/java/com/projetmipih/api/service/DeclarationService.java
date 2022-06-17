package com.projetmipih.api.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetmipih.api.model.Declaration;
import com.projetmipih.api.repository.DeclarationRepository;

import lombok.Data;

@Data
@Service
public class DeclarationService {

	@Autowired
	private DeclarationRepository declarationRepository;
	
	public Optional<Declaration> getDeclaration(Long id){
		return declarationRepository.findById(id);
	}
	
	public Iterable<Declaration> getAllDeclarations(){
		return declarationRepository.findAll();
	}
	
	public void deleteDeclaration(Long id) {
		 declarationRepository.deleteById(id);
	}
	
	public Declaration saveDeclaration(Declaration declaration) {
		Declaration savedDeclaration = declarationRepository.save(declaration);
		return savedDeclaration;
	}
	
	
}
