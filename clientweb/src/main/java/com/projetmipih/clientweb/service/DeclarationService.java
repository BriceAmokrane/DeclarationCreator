package com.projetmipih.clientweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetmipih.clientweb.model.Declaration;
import com.projetmipih.clientweb.repository.DeclarationProxy;

import lombok.Data;

@Data
@Service
public class DeclarationService {

    @Autowired
    private DeclarationProxy employeeProxy;

    public Declaration getDeclaration(Long id) {
        return employeeProxy.getDeclaration(id);
    }

    public Iterable<Declaration> getDeclarations() {
        return employeeProxy.getDeclarations();
    }

    public void deleteDeclaration(Long id) {
        employeeProxy.deleteDeclaration(id);;
    }

     public Declaration saveDeclaration(Declaration declaration) {
        Declaration savedDeclaration;

        declaration.setNomEmploye(declaration.getNomEmploye().toUpperCase());

        savedDeclaration = employeeProxy.createEmployee(declaration);
    
        return savedDeclaration;
    }
     

}